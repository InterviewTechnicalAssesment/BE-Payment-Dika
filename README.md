# Microservices - Restauran Promo Services

## Introduction
This is a showcase of 3 microservices Fully conteneraized with all it dependency, working side by side to do simple task that start with you **Choosing Menu**, **Get Promo**, and **Create Payment**. In doing so, these microservices will utilize various important concept of microservices such as **REST API**, **Containerization**, **Log Interceptor**, **Error Handling**, and many more.

All This services are build utilizing several technology such as:
* SpringBoot v2.1.6
* Java 8
* Docker v19.03.12
* Docker-Compose v1.27.2
* MySQL v8

## Prerequisite
In order to start the services smoothly, it is strongly reccomended that you have docker-compose and docker instaled. To do so you can visit this [LINK](https://www.docker.com/products/docker-desktop) to install docker desktop suitable with your operating system.
>Both docker and docker-compose are included in Docker Desktop

## General Instruction

To run all the services including its dependency make sure you have all the prerequisite. Put docker-compose.yml and sql folder in root. Once all prerequisite all meet, there is only several step left which will be explained on the later section


## Running the Services
It is crucial to do it in sequence before starting the next step

### 1. Clone this Repository
Go to your terminal or command prompt and clone this repository

After the cloning process finish, navigate to the root directory of this project with the following command
```script
cd ms-inventor
```

### 2. Bring all Services up
On the root directory turn on all services with docker-compose
```script
docker-compose up --build
```
>Wait for a couple of minutes until you see something similar to this 
**... Started [XXX]Microservice in 28.689 seconds ...**

Thats it, all services are up and running. Next step would explain on how the Microservices works and the background.


### 1. Get Menu
In this Restaurant Promo Services, you gonna want to see all the menu can choose. Lets start by seing our catalog right on our browser. Go fire up your browser and enter the following URL
```script
http://localhost:10022/swagger-ui.html
```
This will direct you to the **Restaurant's Swagger UI**. Let's go to the catalogs by expanding the ***Menu Controller**. After that that find the following **/menu**. Hit that **try it out** and then the **execute** button.

You will receive the following response
```script
[
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": 1602606412000,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 1,
    "restaurant_id": 1,
    "name": "Ayam Gulai",
    "category": "Lauk Utama",
    "photo_url": "https://www.islampos.com/wp-content/uploads/2018/01/gulai-ayam-.jpg",
    "price": 15000
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": 1602606412000,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 2,
    "restaurant_id": 1,
    "name": "Rendang",
    "category": "Lauk Utama",
    "photo_url": "https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2020/05/23/2598383914.jpg",
    "price": 18000
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": 1602606412000,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 3,
    "restaurant_id": 1,
    "name": "Teh Talua",
    "category": "Minuman",
    "photo_url": "https://akcdn.detik.net.id/community/media/visual/2019/10/02/2afcb3ad-6b85-416b-bd88-814b3d478f47_169.jpeg?w=700&q=90",
    "price": 5000
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": 1602606412000,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 4,
    "restaurant_id": 1,
    "name": "Kerupuk Jangek",
    "category": "Lauk Sampingan",
    "photo_url": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Kerupuk_kulit.JPG/500px-Kerupuk_kulit.JPG",
    "price": 3000
  }
]
```

From this information we can see that there are 5 items with its of menu as well as prices. For today let's buy 20 of Ayam gulai and 10 of Rendang.

### 2. Get Payment Type
Before we can pay, we can choose our payment type by using :
```script
http://localhost:10023/swagger-ui.html
```

After it open up, navigate to the order-controller and expand it. Find the **/payment_type** and again expand it.
and try :

```script
[
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 1,
    "type": "CASH",
    "bank": null,
    "name": null
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 2,
    "type": "CREDIT CARD",
    "bank": "ABC",
    "name": "PRECIOUS"
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 3,
    "type": "CREDIT CARD",
    "bank": "ABC",
    "name": "SIGNATURE"
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 4,
    "type": "CREDIT CARD",
    "bank": "ABC",
    "name": "TRAVELOKA"
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 5,
    "type": "CREDIT CARD",
    "bank": "ABC",
    "name": "SKYZ"
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 6,
    "type": "CREDIT CARD",
    "bank": "ABC",
    "name": "PERTAMINA"
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 7,
    "type": "CREDIT CARD",
    "bank": "ABC",
    "name": "GOLF SIGNATURE"
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 8,
    "type": "CREDIT CARD",
    "bank": "ABC",
    "name": "GOLF PLATINUM"
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 9,
    "type": "CREDIT CARD",
    "bank": "ABC",
    "name": "GOLF GOLD"
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 10,
    "type": "DEBIT",
    "bank": "ABC",
    "name": null
  },
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 11,
    "type": "EMONEY",
    "bank": "ABC",
    "name": null
  }
]
```

we can choose our payment type
### 3 Get Promo
Now we got our restaurant id and payment type id

To do so, navigate to the swagger-ui of Promo Microservice by entering the following address on your favorite browser
```script
http://localhost:10024/swagger-ui.html
```

After it open up, navigate to the order-controller and expand it. Find the **/promo/paymentTypeId/{paymentTypeId}/restaurantId/{restaurantId}** and again expand it.

Now we want to use paymentTypeId 5 and RestaurantId 1



Click **try it out** and then enter the following example on the New Order Detail Box
```script
[
  {
    "createdBy": null,
    "updatedBy": null,
    "created_at": null,
    "updated_at": null,
    "status": "ACTIVE",
    "id": 1,
    "promo_type": "DISCOUNT",
    "paymentTypeId": 5,
    "restaurantId": 1,
    "reqBonusMenuId": null,
    "reqBonusMenuIdQty": null,
    "menuIdBonus": null,
    "menuIdBonusQty": null,
    "reqDiscountMin": 500000,
    "discount": 10,
    "discountMax": 500000
  }
]
```

### 4 Payment

With all of the information, you can do payment with

```script
http://localhost:10023/swagger-ui.html
```

And got to payment/create
Fill all the information you got.
And Done!

And thats it! your order status are completed and time to enjoy all those good stuff and promo you got.

Congratulation you have just finish reading everything and hope you can better understand how microservices and how its component are working together to create this fascinating technology! 

~ All the best 

## Appendix
Please find below all of the services endpoint as well as rabbitMQ and MySQLDB
1. Restaurant Microservice
```script
http://localhost:10022/swagger-ui.html
```
2. Payment Microservice
```script
http://localhost:10023/swagger-ui.html
```
3. Promo Microservice
```script
http://localhost:10024/swagger-ui.html
```