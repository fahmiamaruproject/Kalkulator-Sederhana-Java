import java.util.Scanner;

public class KalkulatorSederhana {
    public static void main(String[] args) {
        System.out.println("Selamat datang di Kalkulator Sederhana!");

        double angka1 = inputAngka("Masukkan angka pertama: ");
        double angka2 = inputAngka("Masukkan angka kedua: ");
        int pilihanOperasi = pilihOperasi();

        do {
            double hasil = hitung(angka1, angka2, pilihanOperasi);

            System.out.println("Hasil: " + hasil);

            String jawaban = ulangiProgram();
            switch (jawaban.toLowerCase()) {
                case "angka":
                    angka1 = inputAngka("Masukkan angka pertama: ");
                    angka2 = inputAngka("Masukkan angka kedua: ");
                    break;
                case "operasi":
                    pilihanOperasi = pilihOperasi();
                    break;
                case "tidak":
                    System.out.println("Terima kasih telah menggunakan Kalkulator Sederhana. Selamat tinggal!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Program akan diakhiri.");
                    System.exit(0);
            }

        } while (true);
    }

    private static double inputAngka(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    private static int pilihOperasi() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih operasi: ");
        System.out.println("1. Penjumlahan (+)");
        System.out.println("2. Pengurangan (-)");
        System.out.println("3. Perkalian (*)");
        System.out.println("4. Pembagian (/)");

        System.out.print("Masukkan pilihan operasi (1-4): ");
        return scanner.nextInt();
    }

    private static double hitung(double angka1, double angka2, int pilihan) {
        double hasil = 0;

        switch (pilihan) {
            case 1:
                hasil = angka1 + angka2;
                break;
            case 2:
                hasil = angka1 - angka2;
                break;
            case 3:
                hasil = angka1 * angka2;
                break;
            case 4:
                if (angka2 != 0) {
                    hasil = angka1 / angka2;
                } else {
                    System.out.println("Error: Tidak bisa melakukan pembagian dengan nol.");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Error: Pilihan operasi tidak valid.");
                System.exit(0);
        }

        return hasil;
    }

    private static String ulangiProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Apakah Anda ingin mengubah angka, operasi, atau mengakhiri program? (angka/operasi/tidak): ");
        return scanner.next();
    }
}
