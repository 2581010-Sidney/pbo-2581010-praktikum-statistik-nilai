import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.util.Collections;

public class StatistikNilai {

    static final int SELESAI = -1;

    static int indexGrade(int nilai) {
        if(nilai>=90) return 0;
        if(nilai>=80) return 1;
        if(nilai>=70) return 2;
        if(nilai>=60) return 3;
        return 4;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("==== STATISTIK NILAI KELAS ====");
        System.out.println("ketik -1 kalau sudah selesai.");

        int nilai = 0;
        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println(" Ditolak, harus berupa angka");
                continue;
            }
            nilai = scanner.nextInt();

            if (nilai == SELESAI) {
                continue;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println(" Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);
        } while (nilai != SELESAI);

        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai yang dimasukan, statistik tidak dapat di hitung.");
            return;
        }

        int total = 0;
        for (int n : daftar) {
            total += n;
        }

        double rata = (double) total / daftar.size();

        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int n : daftar) {
            if (n > tertinggi) tertinggi = n;
            if (n < terendah) terendah = n;
        }

        int diAtasRata = 0;
        for (int n: daftar){
            if (n > rata) diAtasRata++;
        }

        int[] jumlahGrade = new int [5];
        for (int n : daftar){
            jumlahGrade[indexGrade(n)]++;
        }

        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        String labelGrade = "ABCDE";
        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah : " + daftar.size());
        System.out.println("Rata-rata : " +
                String.format(Locale.forLanguageTag("id-ID"), "%.2f", rata));
        System.out.println("Tertinggi : " + tertinggi);
        System.out.println("Terendah : " + terendah);
        System.out.println("Di atas rata2 : "+ diAtasRata + " orang");

        System.out.print("Distribusi :");
        for(int i = 0; i< jumlahGrade.length; i++){
            System.out.print(" " + labelGrade.charAt(i) + "=" + jumlahGrade[i]);
        }
        System.out.println();

        System.out.println("Terurut : " + terurut);
        System.out.println("Urutan asli : " + daftar);
    }
}