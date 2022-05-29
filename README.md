# n11
# verilen test case UI ve API testi yapıldı
UI kısmında okunması ve raporlaması en anlasılır olan CUCUMBER framworkunu kullandım
pages package'nda  locateler alındı ve yazıldı

# pogos package
apı icin datalar olusturuldu
# Runner 
raporlar için , kosturulacak testlerin tagları ve eksik kalan stepleri tespit etmek icin dryRun true 
yapılir ve raporları almak icin testler runner classından calıstırılır ve target in altında cucumberRaporsdan raporlar browser da acılarak görüntülenir


# stepdefinition da
kodlar yazılır 

#utilities de
driver , kullanılacak methodlar ve kullanılacak url ın daha kolay alınması icin configuration.properties
in baglantısı saglanır
#feature de ise 
stepler yazılır ve calistırılır kodların yazılacagı alan local e gelir localden alınır
sttep definition a yapıstırılır ve kodlar yazılır
#pom.xml de
gerekli kütüphaneler dependecies icerisine eklenir(gherkin plugin)
#configuration.properties
de hangi browser kullanılacagı proge kapsamında kullanılacak data lar burdan diger claslara rahatlıkla get edilir ve kodlar daha dinamik olur
