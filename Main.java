import java.util.Scanner;

class Main {
  public static Scanner scanner = new Scanner(System.in);

	public static String ask(String message, String example) {
		System.out.println(message);
		System.out.println("Например: " + example);
    System.out.print(">> ");
		String input = scanner.nextLine();
    System.out.println();
    return input;
	}

  public static int extractTime(String task, String phrase) {
	  int pos = task.indexOf(phrase);
	  pos += phrase.length();
	  String timeStr = task.substring(pos, pos + 2);
	  timeStr = timeStr.trim();
	  int time = Integer.parseInt(timeStr);
	  return time;
  }

	public static void main(String[] args) {
		String name = ask("Имя", "Петя");

    int totalTime = 0;
    int totalFinishTime = 0;
    int maxTime = 0;
    int tasksCount = 0;

    while (true) {
      String input = ask(
        "Введи задачу на сегодня или end для выхода",
        "Буду программировать, начну с 11 и закончу в 17 часов"
      );

      if (input.equals("end")) {
        break;
      }

      String task = input;

      int startTime = extractTime(task, "начну с ");
      int endTime = extractTime(task, "закончу в ");
      int spentTime = endTime - startTime;

      totalTime += spentTime;
      totalFinishTime = Math.max(totalFinishTime, endTime);
      maxTime = Math.max(maxTime, spentTime);
      tasksCount++;
    }

    System.out.println(
      "Уважаемый, " + name + "! О ваших планах на сегодня:\n" +
      "  Всего задач: " + tasksCount + "\n" +
      "  Последняя закончится в " + totalFinishTime + "\n" +
      "  В среднем задача занимает " +
          (tasksCount != 0 ? ((totalTime * 60.0) / tasksCount) : 0) + " минут\n" +
      "  Все задачи займут " + 
          totalTime + " часов\n" +
      "УДАЧИ НА СЕГОДНЯ! :)"
    );
	}
}