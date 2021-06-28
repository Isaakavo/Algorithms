public class DashTree {

    public static void main(String[] args) throws InterruptedException {

        StringBuilder dash = new StringBuilder("#");
        int totalLines = 10;
        int cycles = 10;
        long delay = 35;
        print(dash + "\n");


        for(int i = 0; i < cycles; i++){
            int lines = 1;
            while (lines < totalLines){
                dash.append("#");
                if (dash.length() % 2 == 0){
                    print(dash + "\n");
                    lines++;
                    Thread.sleep(delay);
                }
            }
            lines = 1;
            while (lines < totalLines){
                dash.deleteCharAt(dash.length() - 1);
                if (dash.length() % 2 == 0){
                    if (dash.length()== 0) dash.append("#");
                    print(dash + "\n");
                    lines++;
                    Thread.sleep(delay);
                }
            }
        }
    }

    static void print(String value){
        System.out.print(value);
    }
}
