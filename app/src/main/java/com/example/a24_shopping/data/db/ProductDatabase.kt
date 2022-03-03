package com.example.a24_shopping.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.a24_shopping.data.db.dao.ProductDao
import com.example.a24_shopping.data.entity.product.ProductEntity
import com.example.a24_shopping.utillity.DateConverter

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)


@TypeConverters(DateConverter::class)
abstract class ProductDatabase(): RoomDatabase() {

    companion object {
        const val DB_NAME = "ProductDataBase.db"
    }

    abstract fun productDao(): ProductDao
}