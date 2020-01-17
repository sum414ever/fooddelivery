First you need add some restaurants

[POST] http://localhost:8080/restaurant

{
	"id" : 1,
	"name" : "China Food",
	"deliveryAvgTime" : "HOUR",
	"deliveryPrice" : "30.0"
}

{
  "id" : 2,
	"name" : "Shavyha",
	"deliveryAvgTime" : "HALF_HOUR",
	"deliveryPrice" : "20.0"
}

{
  "id" : 3,
	"name" : "Pizza Boy",
	"deliveryAvgTime" : "HOUR",
	"deliveryPrice" : "40.0"
}

{
  "id" : 4,
	"name" : "Vegan Power",
	"deliveryAvgTime" : "HALF_HOUR",
	"deliveryPrice" : "50.0"
}
-------
Than you can see the list of all restaurants

[GET] http://localhost:8080/restaurant
-------
Than you can register your account

[POST] http://localhost:8080/user

{
	"id" : "1",
	"userName" : " Lovely Customer",
	"phoneNumber" : "0507776655",
	"email" : "LC@gmail.com",
	"address" : "Kiev, Lenina, 5"
}
-------
Than you can add some products

[POST] http://localhost:8080/product

{
	"name" : "sushi",
	"price" : 100.0,
	"restaurantId" : "1"
}

{
	"name" : "misso soup",
	"price" : 150.0,
	"restaurantId" : "1"
}

{
	"name" : "shaurma",
	"price" : 30.0,
	"restaurantId" : "2"
}

{
	"name" : "shaurma King size",
	"price" : 55.0,
	"restaurantId" : "2"
}

{
	"name" : "pepperony",
	"price" : 110.0,
	"restaurantId" : "3"
}

{
	"name" : "pepperony XXL",
	"price" : 190.0,
	"restaurantId" : "3"
}

{
	"name" : "sandwich with avocado",
	"price" : 30.0,
	"restaurantId" : "4"
}

{
	"name" : "selera juice",
	"price" : 25.0,
	"restaurantId" : "4"
}
-------
Show all products
[GET] http://localhost:8080/product
-------
Show all products by restaurant id
[GET] http://localhost:8080/product/1
-------
After that you can make your order

[POST] http://localhost:8080/order

{
	"userId" : "1",
	"products" : [
	"shaurma",
	"pepperony"]
}

