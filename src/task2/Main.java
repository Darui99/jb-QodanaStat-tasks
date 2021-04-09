package task2;

import java.util.concurrent.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {

    public static boolean matches(final String text, final String regex) {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final Future<Boolean> future = executor.submit(() -> {
            try {
                return Pattern.compile(regex).matcher(text).matches();
            } catch (PatternSyntaxException e) {
                System.out.println(e.getMessage());
                return false;
            }
        });
        executor.shutdown();
        try {
            return future.get(60, TimeUnit.SECONDS);
        } catch (final ExecutionException | InterruptedException ignored) {
            // pass
        } catch (TimeoutException ignored) {
            future.cancel(true);
        }
        return false;
    }
}
