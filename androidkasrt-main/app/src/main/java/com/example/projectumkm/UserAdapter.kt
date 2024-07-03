package com.example.projectumkm
import java.text.NumberFormat
import java.util.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.projectumkm.model.DataItem

class UserAdapter(private var users: MutableList<DataItem>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_user,parent,false)
        return ListViewHolder(view)

    }

    fun addUser(newUsers: DataItem){
        users.add(newUsers)
        notifyItemInserted(users.lastIndex)
    }

    fun clear(){
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = users[position]
        Glide.with(holder.itemView.context)
            .load(user.foto)
            .apply(RequestOptions().override(80,80).placeholder(R.drawable.ic_launcher_foreground))
            .transform(CircleCrop())
            .into(holder.ivAvatar)

        // Memformat angka ke dalam format Rupiah
        val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("id", "ID"))

        holder.tvUserName.text = "${user.firstName} ${user.lastName}"
        holder.tvEmail.text = user.email
        holder.tvAlamat.text = user.alamat
        holder.tvIuranIndividu.text =  currencyFormatter.format(user.total_iuran_individu)
        holder.tvIuranIndividuBulanan.text =  currencyFormatter.format(user.jumlah_iuran_bulanan)
        holder.tvRekapIuranBulanan.text = currencyFormatter.format(user.total_iuran_warga_pada_akhir_rekap_iuran_bulanan)
        holder.tvPengeluaranIuran.text =  currencyFormatter.format(user.pengeluaran_iuran_dari_hasil_iuran_warga)
        holder.tvPemanfaatanIuran.text =  user.pemanfaatan_dari_iuran_warga_untuk_apa_saja

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvUserName: TextView = itemView.findViewById(R.id.itemName)
        var tvEmail: TextView = itemView.findViewById(R.id.itemEmail)
        var tvAlamat: TextView = itemView.findViewById(R.id.itemAlamat)
        var tvIuranIndividu: TextView = itemView.findViewById(R.id.itemIuranIndividu)
        var tvIuranIndividuBulanan: TextView = itemView.findViewById(R.id.itemIuranBulanan)
        var tvRekapIuranBulanan: TextView = itemView.findViewById(R.id.itemRekapIuranBulanan)
        var tvPengeluaranIuran: TextView = itemView.findViewById(R.id.itemPengeluaranIuran)
        var tvPemanfaatanIuran: TextView = itemView.findViewById(R.id.itemPemanfaatanIuran)
        var ivAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
    }



}