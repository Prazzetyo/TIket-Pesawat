/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketpesawat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author WINDOWS 10
 */
public class TiketPesawat {
    static Scanner sc = new Scanner(System.in);
    static String[][] pesawat = new String[30][9];
    static String[] rute = {"Jakarta-Surabaya", "Surabaya-Jakarta", "Jakarta-Bali", "Jakarta-Yogyakarta", "Bali-Jakarta", "Jakarta-Medan",
        "Yogyakarta-Jakarta", "Medan-Jakarta", "Jakarta-Makassar"};
    static String[][] pes_rut
            = {{"AI01", "Air Asia" + "\t" + " 06.00 - 12.00", "rute[0]"},
            {"AI02", "Air Asia" + "\t" + " 08.00 - 09.15", "rute[1]"},
            {"AI03", "Air Asia" + "\t" + " 15.30 - 18.00", "rute[2]"},
            {"BA01", "Batik Air" + "\t" + " 14.00 - 15.00", "rute[3]"},
            {"BA02", "Batik Air" + "\t" + " 17.20 - 19.57", "rute[4]"},
            {"CI01", "Citilink" + "\t" + " 05.00 - 09.40", "rute[5]"},
            {"CI02", "Citilink" + "\t" + " 08.50 - 12.20", "rute[6]"},
            {"CI03", "Citilink" + "\t" + " 10.50 - 11.00", "rute[7]"},
            {"GI01", "Garuda Indo" + "\t" + " 17.52 - 20.50", "rute[8]"},
            {"GI02", "Garuda Indo" + "\t" + " 16.40 - 18.00", "rute[0]"},
            {"LI01", "Lion Air" + "\t" + " 14.00 - 15.50", "rute[1]"},
            {"LI02", "Lion Air" + "\t" + " 17.00 - 19.00", "rute[2]"},
            {"LI03", "Lion Air" + "\t" + " 20.00 - 21.52", "rute[3]"},
            {"MA01", "Malindo Air" + "\t" + " 22.00 - 24.00", "rute[4]"},
            {"MA02", "Malindo Air" + "\t" + " 15.40 - 19.00", "rute[5]"},
            {"SR01", "Sriwijaya Air" + "\t" + " 09.20 - 12.00", "rute[6]"},
            {"SR02", "Sriwijaya Air" + "\t" + " 06.50 - 08.30", "rute[7]"},
            {"SR03", "Sriwijaya Air" + "\t" + " 08.40 - 12.00", "rute[8]"},
            {"TA01", "Trigana Air" + "\t" + " 15.30 - 17.00", "rute[0]"},
            {"TA02", "Trigana Air" + "\t" + " 18.00 - 19.20", "rute[1]"},
            {"WA01", "Wings Air" + "\t" + " 06.06 - 08.08", "rute[2]"},
            {"WA02", "Wings Air" + "\t" + " 13.30 - 16.40", "rute[3]"},
            {"WA03", "Wings Air" + "\t" + " 20.25 - 22.00", "rute[4]"},
            {"XA01", "Xpress Air" + "\t" + " 22.12 - 01.12", "rute[5]"},
            {"XA02", "Xpress Air" + "\t" + " 16.40 - 19.00", "rute[6]"},
            {"XA03", "Xpress Air" + "\t" + " 12.45 - 15.30", "rute[7]"},
            {"XA04", "Xpress Air" + "\t" + " 10.10 - 13.45", "rute[8]"}};

    static int[] harga = new int[30];
    static int[] temp_harga = {150000, 175000, 200000, 225000, 250000, 275000, 
        300000, 325000, 350000, 375000, 400000, 425000, 450000, 475000, 500000, 
        525000, 550000, 575000, 600000, 300000, 325000, 350000, 375000, 400000, 
        425000, 450000, 475000};

    static int total_kursi = 30;
    static int[][] pesan = new int[30][3];
    static char ulang = 0;
    static int pilih_maskapai, pilih_penerbangan, kursi, total = 0, pilih_menu, n = 0;
    static String kode_maskapai;
    
    static void TampungNilai() {
        for (int i = 0; i < pes_rut.length; i++) {
            for (int j = 0; j < pes_rut[0].length; j++) {
                pesawat[i][j] = pes_rut[i][j];
            }
        }
        for (int i = 0; i < temp_harga.length; i++) {
            harga[i] = temp_harga[i];
        }
    }
    
    static void rutepenerbangan() {
        System.out.println("Rute Penerbangan: ");
        System.out.println("--------------------------------");
        System.out.println("            RUTE                ");
        System.out.println("--------------------------------");
        for (int i = 0; i < rute.length; i++) {
            System.out.println((i + 1) + ". " + rute[i]);
        }
        System.out.println("--------------------------------");
        System.out.print("Pilih : ");
        pilih_maskapai = sc.nextInt();

        System.out.println("");
        kode_maskapai = pesawat[pilih_maskapai - 1][2];
        System.out.println("===========================  MASKAPAI ==========================");
        for (int i = 0; i < pes_rut.length; i++) {
            if (pes_rut[i][2] == kode_maskapai) {
                for (int j = 0; j < pes_rut[0].length; j++) {
                }
                System.out.println(pes_rut[i][0] + "\t" + pes_rut[i][1] + "\t" + harga[i] + "\t");
            }
        }
        System.out.println("================================================================");
    }
    
    static void pesan() {
        System.out.println("Jumlah kursi : " + total_kursi);
        System.out.print("Masukkan Tanggal Keberangkatan(dd-MM-yyyy) : ");
        String oldDate = sc.next();
        SimpleDateFormat tanggal = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(tanggal.parse(oldDate)); 
//digunakan untuk untuk menangkap kesalahan
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Masukkan kode\t: ");
        kode_maskapai = sc.next();

        do {
            System.out.print("jumlah kursi\t: ");
            kursi = sc.nextInt();
            if (kursi > 5) {
                System.out.println("Maksimal pemesanan 5 tiket!");
            } else if (kursi < 1) {
                System.out.println("Minimal pemesanan 1 tiket!");
            }
        } while (kursi > 5 || kursi < 1);

        for (int i = 0; i < pesawat.length; i++) {
            if (pesawat[i][0] != null) {
                if (pesawat[i][0].equalsIgnoreCase(kode_maskapai)) {
                    pilih_penerbangan = i;
                }
            }
        }
        total_kursi = total_kursi - kursi;

        pesan[n][0] = pilih_penerbangan;
        pesan[n][1] = kursi;
        pesan[n][2] = harga[pilih_penerbangan] * kursi;
        n++;

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("                 BOOKING                 ");
        System.out.println("=========================================");
        for (int i = 0; i < pesan.length; i++) {
            if (pesan[i][1] != 0) {
                System.out.println((i + 1) + ". " + pesawat[pesan[i][0]][1] + "\t" + oldDate);
                total = total + pesan[i][2];
            }
        }
        System.out.println(" ");
        System.out.println("               PASSENGER                 ");
        System.out.println("=========================================");
        for (int i = 1; i <= kursi; i++) {
            System.out.print("Masukan Nama Penumpang  " + i + " : ");
            String nama = sc.next();
            System.out.print("Masukan ID(KTP/SIM)       : ");
            String id = sc.next();
        }
        System.out.println("-----------------------------------------");
        {
            int i = 0;
            System.out.println("Total\t: " + "\t" + pesan[i][1] + "\t" + total);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        TampungNilai();
        do {
            System.out.println("");
            System.out.println("\t  ----------------WKWKWK.com-------------------");
            System.out.println("===============================================================");
            System.out.println("Pilihan Menu");
            System.out.println("1. Rute Penerbangan");
            System.out.println("2. Pesan");
            System.out.println("3. Exit");
            System.out.println("===============================================================");
            do {
            System.out.print("Masukkan Pilihan Anda : ");
            pilih_menu = sc.nextInt();
            } while (pilih_menu < 1 || pilih_menu > 3);
            switch (pilih_menu) {
                case 1:
                    rutepenerbangan();
                    do {
                    System.out.print("Kembali ke menu awal? (Y/T) ");
                    ulang = sc.next().charAt(0);
                    } while (ulang != 'y' && ulang != 't' && ulang != 'Y' && ulang != 'T');
                    break;
                case 2:
                    rutepenerbangan();
                    pesan();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (ulang == 'y' || ulang == 'Y');
    }
    
}
