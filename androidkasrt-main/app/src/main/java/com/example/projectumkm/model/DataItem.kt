package com.example.projectumkm.model

import com.google.gson.annotations.SerializedName



data class DataItem(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("firstname")
    val firstName: String? = null,

    @field:SerializedName("lastname")
    val lastName: String? = null,

    @field:SerializedName("foto")
    val foto: String? = null,

    @field:SerializedName("alamat")
    val alamat: String? = null,

    @field:SerializedName("jumlah_iuran_bulanan")
    val jumlah_iuran_bulanan: Int? = null,

    @field:SerializedName("total_iuran_individu")
    val total_iuran_individu: Int? = null,

    @field:SerializedName("pengeluaran_iuran_dari_hasil_iuran_warga")
    val pengeluaran_iuran_dari_hasil_iuran_warga: Int? = null,

    @field:SerializedName("total_iuran_warga_pada_akhir_rekap_iuran_bulanan")
    val total_iuran_warga_pada_akhir_rekap_iuran_bulanan: Int? = null,

    @field:SerializedName("pemanfaatan_dari_iuran_warga_untuk_apa_saja")
    val pemanfaatan_dari_iuran_warga_untuk_apa_saja: String? = null,


)
