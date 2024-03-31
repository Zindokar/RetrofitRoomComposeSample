package iesharia.retrofit2example.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import iesharia.retrofit2example.data.db.Product
import iesharia.retrofit2example.data.db.ProductDao

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase: RoomDatabase() {
    abstract val dao: ProductDao
}