plugins {
   java
}

repositories {
   jcenter()
}

dependencies {
   implementation("javazoom:jlayer:1.0.1")
   implementation("javax.media:jmf:2.1.1e")
   implementation("com.pojosontheweb:monte-repack:1.0.1")

   // https://stackoverflow.com/a/56557241
   // http://www.randelshofer.ch/monte/: If using this, you need "AVIDemo.jar" from here.
   // implementation(files("src/jar/AVIDemo.jar"))
}

sourceSets {
   main {
      java.srcDir("src")
   }
}

java {
   sourceCompatibility = JavaVersion.VERSION_1_8
   targetCompatibility = JavaVersion.VERSION_1_8
}
