#include <jni.h>
#include <string>

/*extern "C" JNIEXPORT jstring JNICALL
Java_com_example_nativeisprime_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject ) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}*/
extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_nativeisprime_MainActivity_isPrime(
        JNIEnv* env,
        jobject /* this */,
        jint num) {
        int i;
        bool isPrime = true;
        for(i = 2; i <= num / 2; ++i)
          {
              if(num % i == 0)
              {
                  isPrime = false;
                  break;
              }
          }

    return isPrime;
}
