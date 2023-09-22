import javax.swing.JOptionPane;

public class _09011282328115_Kevin_SK1A_02{
	public static void main(String[] args) {
		// Pengisian data section 
		String nama = JOptionPane.showInputDialog("Masukkan nama anda: ");
		String nama_umur = JOptionPane.showInputDialog("Masukkan umur anda: ");
		String nama_alamat = JOptionPane.showInputDialog("Masukkan alamat anda: ");
		

		String[] jenisKelaminOptions = {"Laki-laki", "Perempuan"};
		int jenisKelaminIndex = JOptionPane.showOptionDialog(null, "Pilih jenis kelamin", "Jenis Kelamin",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, jenisKelaminOptions, jenisKelaminOptions[0]);

		// Penggunaan if else dan if else if

		String jenisKelamin;
		if (jenisKelaminIndex ==0){
			jenisKelamin = "Laki-laki";
		} else if (jenisKelaminIndex == 1){
			jenisKelamin = "Perempuan";
		}else {
			jenisKelamin = "Tidak valid";
		}

		// Penggunaan JOptionPane
		String[] jabatanOptions = {"Mahasiswa", "Dosen"};
		int jabatanIndex = JOptionPane.showOptionDialog(null, "Pilih jabatan", "Jabatan",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, jabatanOptions, jabatanOptions[0]);


		String jabatan;
		if (jabatanIndex ==0){
			jabatan = "Mahasiswa";
		}else if (jabatanIndex ==1) {
			jabatan = "Dosen";
		}else {
			jabatan = "Tidak Valid";
		}


		String[] fakultasOptions = {"Teknik", "Ekonomi", "Hukum", "Ilmu Komputer", "Kedokteran", "Pertanian", 
									"Keguruan dan Ilmu Pendidikan", "Ilmu Sosial dan Ilmu Politik", 
									"Matematika dan Imu Pengetahuan Alam", "Kesehatan Masyarakat"};
		String fakultas = (String) JOptionPane.showInputDialog(null, "Pilih Fakultas", "Fakultas",
				JOptionPane.PLAIN_MESSAGE, null, fakultasOptions, fakultasOptions[0]);

		String programStudi;
		switch (fakultas){
			case "Teknik":
				String[] programStudiTeknik = {"Teknik Mesin", "Teknik Electro", "Teknik Sipil", "Teknik Pertambangan", 
				"Teknik Kimia", "Teknik Arsitektur", "Teknik Geologi", };
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiTeknik, programStudiTeknik[0]);
				break;

			case "Ekonomi":
				String[] programStudiEkonomi = {"Akuntansi", "Manajemen", "Ekonomi pembangunan",};
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiEkonomi, programStudiEkonomi[0]);
				break;	

			case "Hukum":
				String[] programStudiHukum = {"Ilmu Hukum", "Kenotariatan"};
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiHukum, programStudiHukum[0]);
				break;	

			case "Ilmu Komputer":
				String[] programStudiIlmukomputer = {"Teknik Informatika", "Sistem Informasi", "Sistem Komputer"};
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiIlmukomputer, programStudiIlmukomputer[0]);
				break;	

			case "Kedokteran":
				String[] programStudiKedokteran = {"Pendidikan Dokter", "Ilmu Keperawatan", "Kedokteran Gigi", "Psikologi"};
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiKedokteran, programStudiKedokteran[0]);
				break;	

			case "Pertanian":
				String[] programStudiPertanian = {"Argonomi", "Ilmu Tanah", "Agribisnis", "Ilmu Hama dan Penyakit Tumbuhan", 
				"Teknik Pertanian", "Teknologi Hasil Pertanian", "Peternakan", "Budidaya Perairan", "Teknologi Hasil Perikanan",
				"Agroekoteknologi"};
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiPertanian, programStudiPertanian[0]);
				break;

			case "Keguruan dan Ilmu Pendidikan":
				String[] programStudiFKIP = {"Pendidikan Bahasa Inggris", "Pendidikan Bahasa Indonesia, Sastra Indonesia dan Daerah",
				"Pendidikan Pancasila dan Kewarganegaraan", "Pendidikan Sejarah", "Pendidikan Ekonomi Kuntansi", "Pendidkan Matematika",
				"Pendidikan Biologi", "Pendidkkan Kimia", "Pendidikan Fisika", "Pendidikan Teknik Mesin", "Pendidikan Jasmani dan Kesehatan",
				"Pendidikan Guru Sekolah Dasar", "Pendidikan Anak Usia Dini", "Pendidikan Bimbingan & Konseling" };
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiFKIP, programStudiFKIP[0]);
				break;				

			case "Ilmu Sosial dan Ilmu Politik":
				String[] programStudiFisip = {"Ilmu Administrasi Negara", "Sosiologi", "Ilmu Komunikasi", "Hubungan Internasional"};
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiFisip, programStudiFisip[0]);
				break;

			case "Matematika dan Imu Pengetahuan Alam":
				String[] programStudiFMIPA = {"Matematika", "Fisika", "Kimia", "Biologi", "Ilmu Kelautan", "Farmasi",
				};
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi: ", "Program Studi",
						JOptionPane.PLAIN_MESSAGE, null, programStudiFMIPA, programStudiFMIPA[0]);
				break;	

			case "Kesehatan Masyarakat":
				String[] programStudiFKM = {"Bagian Administrasi Kebijakan Kesehatan(AKK)","Bagian Gizi Masyarakat",
				"Keselamatan Kesehatan Kerja dan Kesehatan Lingkungan (K3/KL)" };
				programStudi = (String) JOptionPane.showInputDialog(null, "Pilih program Studi Bagian: ", "Program Studi Bagian",
						JOptionPane.PLAIN_MESSAGE, null, programStudiFKM, programStudiFKM[0]);
				break;	


			default:
				programStudi = "Tidak valid";
				break;	
			
		}

		String[] options = {"Lihat Hasil", "Kalkulator", "Tic Tac Toe", "KUIS", "Snake Game"};
		int choice = JOptionPane.showOptionDialog(null, "Pilihan Anda: ", "Pilihan", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);


		String pesan = "Data Anda:\nNama: " + nama + "\nAlamat: " + nama_alamat + "\nUmur: " + nama_umur + 
		"\nJenis Kelamin: " + jenisKelamin + "\nJabatan: " + jabatan + "\nFakultas: " + fakultas + 
		"\nProgram Studi: " + programStudi;

		if (choice ==0){
			// Menampilkan hasil pesan
			int confirmChoice = JOptionPane.showConfirmDialog(null, pesan + "\nApakah Anda ingin manampilkan data?", 
				"Konfirmasi penampilan data!!", JOptionPane.YES_NO_OPTION);
			if (confirmChoice == JOptionPane.YES_NO_OPTION){
				System.out.println(pesan);
			}
		}else if (choice == 1) {
			// Memanggil kalkulator
			FungsiKalkulator Kalkulator=new FungsiKalkulator();
		}else if (choice == 2){
			// Memanggil TikTakto
			FungsiTikTakTo TikTakto = new FungsiTikTakTo();
		}else if (choice == 3){
			// Memanggil Kuis
			FungsiKuis Kuis = new FungsiKuis();
		}else if (choice == 4){
			// Memanggil game ular makan apel
			new SGameFrame();
		}

	}

}