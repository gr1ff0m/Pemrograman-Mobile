class MahasiswaManager {
    // List untuk menyimpan data mahasiswa
    private val mahasiswaList = mutableListOf<Mahasiswa>()

    // Fungsi untuk menampilkan semua mahasiswa
    fun listMahasiswa() {
        if (mahasiswaList.isEmpty()) {
            println("Tidak ada mahasiswa yang terdaftar.")
        } else {
            println("\n=== DAFTAR MAHASISWA ===")
            mahasiswaList.forEach {
                println("ID: ${it.id}, Nama: ${it.nama}, NIM: ${it.nim}, Jurusan: ${it.jurusan}")
            }
        }
    }

    // Fungsi untuk menambahkan data mahasiswa baru
    fun addMahasiswa(nama: String, nim: String, jurusan: String) {
        val id = if (mahasiswaList.isEmpty()) 1 else mahasiswaList.maxOf { it.id } + 1
        mahasiswaList.add(Mahasiswa(id, nama, nim, jurusan))
        println("Mahasiswa '$nama' berhasil ditambahkan dengan ID $id.")
    }

    // Fungsi untuk mengedit data mahasiswa berdasarkan ID
    fun editMahasiswa(id: Int, newNama: String, newNim: String, newJurusan: String) {
        val mahasiswa = mahasiswaList.find { it.id == id }
        if (mahasiswa != null) {
            mahasiswa.nama = newNama
            mahasiswa.nim = newNim
            mahasiswa.jurusan = newJurusan
            println("Data mahasiswa berhasil diperbarui!")
        } else {
            println("Mahasiswa dengan ID $id tidak ditemukan.")
        }
    }

    // Fungsi untuk menghapus mahasiswa berdasarkan ID
    fun deleteMahasiswa(id: Int) {
        val mahasiswa = mahasiswaList.find { it.id == id }
        if (mahasiswa != null) {
            mahasiswaList.remove(mahasiswa)
            println("Mahasiswa '${mahasiswa.nama}' berhasil dihapus.")
        } else {
            println("Mahasiswa dengan ID $id tidak ditemukan.")
        }
    }

    // Fungsi untuk menampilkan detail mahasiswa berdasarkan ID
    fun showMahasiswa(id: Int) {
        val mahasiswa = mahasiswaList.find { it.id == id }
        if (mahasiswa != null) {
            println("\n=== DETAIL MAHASISWA ===")
            println("ID: ${mahasiswa.id}")
            println("Nama: ${mahasiswa.nama}")
            println("NIM: ${mahasiswa.nim}")
            println("Jurusan: ${mahasiswa.jurusan}")
        } else {
            println("Mahasiswa dengan ID $id tidak ditemukan.")
        }
    }
}