# StoreApi
Данный проект представляет из себя api для магазина по продаже товаров технической направленности.

Используется субд H2.

В файле application.yml, находящимся в папке config, вы можете настроить необходимый порт, а также 
логин и пароль субд h2.

Для сборки и запуска вам необходим jdk 17 и apache maven.

Сам процесс сборки оставляется вам на выбор, вы можете как собрать через gradle в intelij,
а также вы можете выполнить сборку вручную из командной консоли.
  ```console
   gradle clean build
   ```
После вы можете найти jar в /build/libs и запустить исполняемый файл через java -jar <название выходного файла>.

Далее вы можете увидеть примеры запросов к api

Добавление товара

POST http://localhost:8081/products
BODY:

вариант для ноутбука

  ```JSON
   {
  "type" : "laptop",
  "serialNumber" : 13242,
  "price" : 10000,
  "manufacturer" : "hp",
  "quantity" : 5,
  "size" : 7
}
   ```

вариант для монитора
```JSON
{
"type" : "monitor",
"serialNumber" : 12232,
"price" : 13000,
"manufacturer" : "hp",
"quantity" : 5,
"diagonal" : 10
}
  ```

вариант для жесткого диска
```JSON
{
"type" : "hardDisk",
"serialNumber" : 1322,
"price" : 2000,
"manufacturer" : "kingstone",
"quantity" : 5,
"diskSizeInGB" : 1000
}
```
вариант для настольного компьютера
```JSON
{
"type" : "desktopComputer",
"serialNumber" : 1322,
"price" : 2000,
"manufacturer" : "hyperpc",
"quantity" : 5,
"formFactor" : "desktop"
}
```
Ответом будет продукт с его id, например
```JSON
{
"id": 2,
"type": null,
"serialNumber": 12232,
"price": 13000,
"manufacturer": "hp",
"quantity": 5,
"diagonal": 10
}
```
получение товара по id

GET http://localhost:8081/products/{id}
ответом может быть
```JSON
{
"id": 2,
"type": "monitor",
"serialNumber": 12232,
"price": 13000,
"manufacturer": "hp",
"quantity": 10,
"diagonal": 10
}
```
получение товаров по типу

GET http://localhost:8081/products/type/{type}
ответом может быть
```JSON
[
{
"id": 3,
"type": "hardDisk",
"serialNumber": 1322,
"price": 2000,
"manufacturer": "kingstone",
"quantity": 5,
"diskSizeInGB": 1000
},
{
"id": 5,
"type": "hardDisk",
"serialNumber": 1322,
"price": 2000,
"manufacturer": "kingstone",
"quantity": 5,
"diskSizeInGB": 1000
},
{
"id": 6,
"type": "hardDisk",
"serialNumber": 1322,
"price": 2000,
"manufacturer": "kingstone",
"quantity": 5,
"diskSizeInGB": 1000
}
]
```
Удаление товара по id

DELETE http://localhost:8081/products/1
Ответом будет код 200

Обновление товара по id

PATCH http://localhost:8081/products/2
BODY:
```JSON
{
    "type" : "monitor",
    "serialNumber" : 12232,
    "price" : 13000,
    "manufacturer" : "hp",
    "quantity" : 10,
    "diagonal" : 10
}
```
Ответ в таком случае будет:
```JSON
{
"id": 2,
"type": "monitor",
"serialNumber": 12232,
"price": 13000,
"manufacturer": "hp",
"quantity": 10,
"diagonal": 10
}
```