package com.example.a24_shopping.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a24_shopping.data.entity.product.ProductEntity
import com.example.a24_shopping.databinding.ViewholderProductItemBinding

class ProductListAdapter :RecyclerView.Adapter<ProductListAdapter.ProductItemViewHolder>() {

    private var productList: List<ProductEntity> = listOf()
    private lateinit var productItemClickListener: (ProductEntity) -> Unit

    inner class ProductItemViewHolder(
        private val binding : ViewholderProductItemBinding,
        val productItemClickListener: (ProductEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: ProductEntity) = with(binding){

        }

        fun bindViews(data: ProductEntity){

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ProductItemViewHolder {
        val view = ViewholderProductItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ProductItemViewHolder(view, productItemClickListener)
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ProductItemViewHolder, position: Int) {
        holder.bindData(productList[position])
        holder.bindViews(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setProductList(productList: List<ProductEntity>, productItemClickListener: (ProductEntity) -> Unit = {}){
        this.productList = productList
        this.productItemClickListener = productItemClickListener
        notifyDataSetChanged()
    }

}