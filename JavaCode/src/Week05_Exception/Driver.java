package Week05_Exception;


/*

                    Throwable
                        |
                        |
                   +----+-----------------+
                   |                      |
                 Error                 Exception (Compile Time)
           (無法在代碼裡 handle)             |
         ex: MemoryOverloadError           |
                                       RuntimeException
 */
public class Driver {

    void fuck(String who) {

        if (who.equals("cat")) {

        }

    }

    public static void main(String[] args) {
        int a = 1 / 0;

    }
}
