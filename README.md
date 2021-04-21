# IntentParcelableApps

 implementasi intent untuk melakukan perpindahan dari activity ke activity lain, dengan atau tidak membawa data. 
 Beberapa bagian dari codelab ini akan menjawab beberapa pertanyaan umum dalam pengembangan aplikasi Android sebagai berikut:

1.Bagaimana berpindah dari satu activity ke activity lain?

2.Bagaimana berpindah dari satu activity ke activity lain dengan membawa data?

     -Single value dari suatu variabel.

     -Obyek model dengan menggunakan Parcelable.
      Parcelable adalah suatu interface yang memungkinkan kita melakukan pengiriman objek dari suatu activity ke activity lain.
      Obyek yang di implementasikan dengan parcelable akan memudahkan dalam mengirimkan data dari satu activity ke activity lainnya.
      
      Contoh object Data:
      
      data class Person(
         val name: String?,
         val age: Int?,
         val email: String?,
         val city: String?
      )


3.Menjalankan komponen di aplikasi lain untuk keperluan membuka browser atau melakukan pemanggilan melalui aplikasi telepon bawaan?

4.Mengirimkan hasil nilai balik melalui Intent.
