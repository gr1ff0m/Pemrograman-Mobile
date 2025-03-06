import java.util.Scanner

// Fungsi utama program
fun main() {
    val scanner = Scanner(System.`in`) // Inisialisasi Scanner untuk input pengguna
    val manager = MahasiswaManager()   // Inisialisasi MahasiswaManager

    // Loop utama untuk menampilkan menu dan memproses pilihan pengguna
    while (true) {
        println("\n=== MENU  MAHASISWA ===")
        println("1. Tambah Mahasiswa")
        println("2. Tampilkan Daftar Mahasiswa")
        println("3. Perbarui Data Mahasiswa")
        println("4. Hapus Mahasiswa")
        println("5. Tampilkan Detail Mahasiswa")
        println("6. Keluar")
        print("Pilih menu (1-6): ")

        // Pilihan pengguna
        when (val choice = scanner.nextLine().toIntOrNull()) {
            1 -> { // Menu 1: Tambah Mahasiswa
                print("Masukkan Nama: ")
                val nama = scanner.nextLine()
                print("Masukkan NIM: ")
                val nim = scanner.nextLine()
                print("Masukkan Program Studi: ")
                val jurusan = scanner.nextLine()
                // Validasi input tidak boleh kosong
                if (nama.isNotEmpty() && nim.isNotEmpty() && jurusan.isNotEmpty()) {
                    manager.addMahasiswa(nama, nim, jurusan)
                } else {
                    println("Input tidak boleh kosong!")
                }
            }
            2 -> { // Menu 2: Tampilkan Daftar Mahasiswa
                manager.listMahasiswa()
            }
            3 -> { // Menu 3: Perbarui Data Mahasiswa
                print("Masukkan ID Mahasiswa yang ingin diperbarui: ")
                val id = scanner.nextLine().toIntOrNull()
                if (id != null) {
                    print("Masukkan Nama Baru: ")
                    val newNama = scanner.nextLine()
                    print("Masukkan NIM Baru: ")
                    val newNim = scanner.nextLine()
                    print("Masukkan Program Studi Baru: ")
                    val newJurusan = scanner.nextLine()
                    // Validasi input tidak boleh kosong
                    if (newNama.isNotEmpty() && newNim.isNotEmpty() && newJurusan.isNotEmpty()) {
                        manager.editMahasiswa(id, newNama, newNim, newJurusan)
                    } else {
                        println("Input tidak boleh kosong!")
                    }
                } else {
                    println("ID tidak valid!")
                }
            }
            4 -> { // Menu 4: Hapus Mahasiswa
                print("Masukkan ID Mahasiswa yang ingin dihapus: ")
                val id = scanner.nextLine().toIntOrNull()
                if (id != null) {
                    manager.deleteMahasiswa(id)
                } else {
                    println("ID tidak valid!")
                }
            }
            5 -> { // Menu 5: Tampilkan Detail Mahasiswa
                print("Masukkan ID Mahasiswa yang ingin dilihat: ")
                val id = scanner.nextLine().toIntOrNull()
                if (id != null) {
                    manager.showMahasiswa(id)
                } else {
                    println("ID tidak valid!")
                }
            }
            6 -> { // Menu 6: Keluar dari program
                println("Terima kasih telah menggunakan program.")
                return // Keluar dari loop dan program
            }
            else -> { // Pilihan tidak valid
                println("Pilihan tidak valid! Silakan pilih angka 1 hingga 6.")
            }
        }
    }
}