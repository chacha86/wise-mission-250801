import java.util.ArrayList;
import java.util.Scanner;

class WiseSaying {
    int number;
    String author;
    String content;

    public WiseSaying(int number, String author, String content) {
        this.number = number;
        this.author = author;
        this.content = content;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = 1;
        ArrayList<WiseSaying> wise = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();
            if (command.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                wise.add(new WiseSaying(no, author, content));
                System.out.println(no + "번 명언이 등록되었습니다.");
                no++;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = wise.size() - 1; i >= 0; i--) {
                    WiseSaying ws = wise.get(i);
                    System.out.println(ws.number + " / " + ws.author + " / " + ws.content);
                }

            } else if (command.startsWith("삭제?id=")) {
                String idPart = command.substring("삭제?id=".length());
                int targetId = Integer.parseInt(idPart);

                boolean removed = wise.removeIf(ws -> ws.number == targetId);

                if (removed) {
                    System.out.println(targetId + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(targetId + "번 명언은 존재하지 않습니다.");
                }

            } else if (command.startsWith("수정?id=")) {
                String idPart = command.substring("수정?id=".length());
                int targetId = Integer.parseInt(idPart);

                boolean found = false;

                for (WiseSaying ws : wise) {
                    if (ws.number == targetId) {
                        System.out.println("명언(기존) : " + ws.content);
                        System.out.print("명언 : ");
                        String newContent = sc.nextLine();

                        System.out.println("작가(기존) : " + ws.author);
                        System.out.print("작가 : ");
                        String newAuthor = sc.nextLine();

                        ws.content = newContent;
                        ws.author = newAuthor;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(targetId + "번 명언이 존재하지 않습니다.");
                }
            } else if (command.equals("종료")) {
                break;
            }
        }
    }
}
