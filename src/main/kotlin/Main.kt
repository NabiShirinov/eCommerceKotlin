open class Product(val name: String, val price: Float) {

    fun getNameProduct() = name

    fun getPriceProduct() = price

    open fun getShippingCost(): Float {
        return 0.05f
    }
}
abstract class Category(val name: String) {

    fun getNameCategory() = name

    abstract fun getProducts(): List<Product>
}
class ElectronicsCategory(name: String) : Category(name) {
    // Hər kategoriya üçün anbardakı məhsulları tanıdırıq ...
    override fun getProducts() = listOf(
        PhysicalProduct("iPhone 13 Pro", 999.99f , weight = 0.05f),
        PhysicalProduct("Samsung Galaxy S22 Ultra", 1199.99f, weight = 0.05f),
        PhysicalProduct("MacBook Pro M1", 1299.99f, weight = 0.05f),
        PhysicalProduct("iPad Air 5", 599.99f, weight = 0.05f)
    )
}

class ClothingCategory(name: String) : Category(name) {

    // Hər kategoriya üçün anbardakı məhsulları tanıdırıq ...
    override fun getProducts() = listOf(
        PhysicalProduct("Gödəkcə", 59.99f, weight = 0.05f),
        PhysicalProduct("Cins şalvar", 79.99f, weight = 0.05f),
        PhysicalProduct("T-Shirt", 29.99f, weight = 0.05f),
        PhysicalProduct("Sviter", 49.99f, weight = 0.05f)
    )
}

class HomeGoodsCategory(name: String) : Category(name) {
    // Hər kategoriya üçün anbardakı məhsulları tanıdırıq ...
    override fun getProducts() = listOf(
        PhysicalProduct("Kofe aparatı", 99.99f, weight = 0.05f),
        PhysicalProduct("Tozsoran", 199.99f, weight = 0.05f),
        PhysicalProduct("Qabyuyan", 499.99f, weight = 0.05f),
        PhysicalProduct("Soyuducu", 1499.99f, weight = 0.05f)
    )
}

interface Shippable {

    fun getShippingCost(): Float
}

class PhysicalProduct(name: String, price: Float, var weight: Float) : Product(name, price), Shippable {
    // Çatırılma pulunu məhsulun qiymətinə görə təyin edirik ...
    override fun getShippingCost(): Float {
        return weight * price
    }

}
class DigitalProduct(name: String, price: Float , var weight: Float) : Product(name, price) {

}
fun main(args: Array<String>) {
    while (true) {
        print("1.Müştəri \n2.Satıcı \n3.Çıxış\nIstifadəçi növünü seçin:")
        var choose = readLine()!!.toInt()
        if (choose == 1) {
            while(true) {
                val categories = listOf(
                    ElectronicsCategory("Elektronika"),
                    ClothingCategory("Paltar"),
                    HomeGoodsCategory("Ev əşyaları")
                )
                var counter = 1;

                println("Kategoriyalar:")
                for (category in categories) {
                    println("  $counter.${category.name}")
                    counter = counter + 1
                }
                print("  $counter.Çıxış\n")
                print("Kategoriya seçin: ")
                val categoryNumber = readLine()!!.toInt()
                if (categoryNumber == counter){
                    return
                }
                val products = categories[categoryNumber - 1].getProducts()
                counter = 1

                println(" ${categories[categoryNumber - 1].name} kateqoriyasındakı məhsullar:")
                for (product in products) {
                    println("  $counter.${product.name}")
                    counter = counter + 1
                }
                print("  $counter.Çıxış\n")

                print("Məhsul seçin: ")
                val productNumber = readLine()!!.toInt()

                if (productNumber == counter){
                    return
                }
                val product = products[productNumber - 1]

                println("Qiymət: ${product.price} manat")

                println("Çatdırılma pulu: ${product.getShippingCost()} manat")
                println("Yeni məhsul sifariş vermək istəyirsiniz mi?(bəli/xeyr)")
                val s = readLine()
                if(s == "bəli"){
                }
                else{
                    return
                }
            }
        }
        else if (choose == 3) {
            return
        } else {
            var isLoggedIn = false

            while (!isLoggedIn) {
                println("Kod daxil edin:")

                val password = readLine()!!

                if (password == "sdf100") // Şifrə : sdf100
                {
                    isLoggedIn = true
                    println("Satıcı girişi təsdiq edildi!")
                    return
                } else {
                    println("Yanlış şifrə!")
                    return
                }
            }
            // Ardı olacaq...
        }
    }
}