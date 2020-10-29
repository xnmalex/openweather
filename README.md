# OpenWeather Android App (Kotlin)

- using MVVM Architeture [refer here](https://developer.android.com/jetpack/guide)
- Retrofit + Kotlin + Dagger2 + Room
- OpenWeatherAPI - https://openweathermap.org/

# Instructions

- Clone the Repository
- Build the Project with Android Studio
- Run the App on simulator or phone
- Alternatively can download the released apk from [here](https://github.com/xnmalex/openweather/blob/master/app/release/app-release.apk)

### Library

OpenWeather uses a number of open source projects to work properly:

- [Retrofit](https://square.github.io/retrofit/) - Networking Library
- [Dagger2](https://developer.android.com/training/dependency-injection/dagger-android) - Dependencies injection with Hilt
- [Room](https://developer.android.com/training/data-storage/room) - Database
- [Picasso](https://square.github.io/picasso/) - Image Loader

And of course itself is open source with a [public repository][openweather]
on GitHub.

### Installation

OpenWeather requires Android [API_LEVEL](https://developer.android.com/studio/releases/platforms) 23+ (Android 6.0) to run.

Sync Gradle (BuildGralde)

### Testing

U can change the default settings on [ApiEndPoint.java](https://github.com/xnmalex/openweather/blob/master/app/src/main/java/com/alexgui/openweather/ApiEndPoint.kt)

- CITY_ID= 1880252(Singapore), [list of cities](http://bulk.openweathermap.org/sample/)
- UNITS = metric (Celcius) //imperial(Fahrenheit)

### Todos

- Write Unit Testing
- Better UI enchancement
- Put API Key in BuildConfig (Security)

## License

**Free Software, Hell Yeah!**

[//]: # "These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax"
[openweather]: https://github.com/xnmalex/openweather
