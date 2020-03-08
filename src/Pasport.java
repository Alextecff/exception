import java.util.Scanner;

public class Pasport {
    public void getPasport() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Введите серию и номер паспорта:");
            String s = scanner.nextLine();
            byte[] chars = s.getBytes();

            for (byte b : chars) {
                System.out.print(b + " ");
            }
            System.out.println();

            if (chars.length == 9 && s.length() == 9) {
                if(chars[2] != 32 ){
                    System.out.println("Введите данные через пробел!");
                    continue;
                }
            } else {
                System.out.println("Не верное количество символов!");
                continue;
            }

            for(int i = 0; i < 2; i++){
                if((chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <= 122)){

                }else {
                    try {
                        throw new PasportException("Серия введена не верно!");
                    } catch (PasportException e) {
                        e.printStackTrace();
                        //System.out.println("Серия введена не верно!");
                        getPasport();
                    } finally {
                        return;
                    }
                }
            }

            for (int i = 3; i < 9; i++){
                if(chars[i] >= 48 && chars[i] <= 57){

                } else {
                    try {
                        throw new PasportException("Номер введён не верно!");
                    } catch (PasportException e) {
                        e.getMessage();
                        //System.out.println("Номер введён не верно!");
                        getPasport();
                    } finally {
                        return;
                    }
                }
            }
            break;
        }
        System.out.println("Данные в базе!");
    }

}
