plugins {
   java
}

repositories {
   jcenter()
   mavenCentral()
}

dependencies {
   implementation("javazoom:jlayer:1.0.1")
   implementation("javax.media:jmf:2.1.1e")

   // https://stackoverflow.com/a/56557241
   implementation(files("src/jar/AVIDemo.jar"))
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
