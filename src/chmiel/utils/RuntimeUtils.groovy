package chmiel.utils

class RuntimeUtils {
    public static void showExecutionTime() {
        def time1 = System.nanoTime()
        Runtime.getRuntime().addShutdownHook {
            def time2 = System.nanoTime()
            println ("\n*** Elapsed time: " + prettifyTime(time2 - time1))
        }
    }

    //TODO: Move to class dedicated to formatting/time
    private static String prettifyTime(long nanoSeconds) {
        long remaining = nanoSeconds / 1_000_000L
        def thousandsSecond = remaining % 1000L
        remaining /= 1000
        def seconds = remaining % 60
        remaining /= 60
        def minutes = remaining % 60
        remaining /= 60
        def hours = remaining

        sprintf("%02d:%02d:%02d.%03d", hours, minutes, seconds, thousandsSecond)
    }
}
