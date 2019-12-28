First you need add some restaurants

[POST] http://localhost:8080/restaurant

{
	"name" : "China Food",
	"deliveryAvgTime" : "HOUR",
	"restaurantType" : "SUSHI",
	"deliveryPrice" : "30.0"
}

{
	"name" : "Shavyha",
	"deliveryAvgTime" : "HALF_HOUR",
	"restaurantType" : "SHAURMA",
	"deliveryPrice" : "20.0"
}

{
	"name" : "Pizza Boy",
	"deliveryAvgTime" : "HOUR",
	"restaurantType" : "PIZZA",
	"deliveryPrice" : "40.0"
}

{
	"name" : "Vegan Power",
	"deliveryAvgTime" : "HALF_HOUR",
	"restaurantType" : "VEGAN",
	"deliveryPrice" : "50.0"
}
-------
Than you can see the list of all restaurants with all menu and price

[GET] http://localhost:8080/restaurant
-------
Than you can register your account

[POST] http://localhost:8080/customer

{
	"userName" : " Lovely Customer",
	"phoneNumber" : "0507776655",
	"email" : "LC@gmail.com",
	"address" : "Kiev, Lenina, 5"
}
-------
After that you can make your order

[POST] http://localhost:8080/order/?restaurantName=Vegan Power&phone=0507776655
