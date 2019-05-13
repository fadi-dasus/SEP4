## Development plan

### Phases

#### Minimum Viable Product For Proof of Concept
- Display a list of rooms in a Spinner
- MVVM
- Web Services

#### Minimum Viable Product For Project (Mandatory)
- Activity which displays CO2, Temperature, Humidity
- MVVM (ViewModel & LiveData, Repository)
- Room Database
- Web Services

#### Expanded Minimum Viable Product (Optional)
- Room choice
- Authorization
- Warning and Report lists activities with nice charts

### Tasks

1. Review and import Model Classes (Ainis, Vladimir, Aleksandr) ✓
2. MVVM Skeleton Code ✓
3. Web Services with Retrofit (Ainis) ✓
4. Repositories ✓
5. ViewModels ✓
6. Navigation Architecture Components ✓
7. All Fragment skeleton code implementation ✓
8. Expanded LoginFragment ✓
9. Expanded RoomMainFragment ✓
10. Expanded RoomChoice ✓
11. Updated Models ✓
12. Connection to Spring Framework ✓
13. Firebase Cloud Messaging ✓
14. Expanded WarningList ✓
15. Toolbar ✓
16. Bottom Navigation View ✓ 
17. MPAndroidChart for displaying today's data ✓
18. Expanded Report
19. Apply Material Design to the whole project
20. Firebase Authentication

### Web API To Follow

- Base URL: https://localhost:8080/sep4/

*Room*
- /room/all - get all rooms

*CO2*
- co2/all - gets all CO2
- co2/room/{id} - gets all CO2 from the past by room id
- co2/roomtoday/{id} - gets all CO2 from today by room id

*Humidity*
- humidity/all - gets all humidities
- humidity/room/{id} - gets all humidities from the past by room id
- humidity/roomtoday{id} -gets all humidities from today by room id

*Temperature*
- temperature/all - gets all temperatures
- temperature/room/{id} - gets all temperatures from the past by room id
- temperature/roomid/{id} - gets all temperatures from today by room id

*Warning*
- warning/roosm/{id} - gets all warnings by room id

*Firebase Cloud Messaging*
- fcm/subscribe - confirms in data tier to start sending FCM to Android

###Tutorials to read

*Sequence is linear!*


- Room Database
	1. Simple Tutorial https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0
	2. Part 1 https://codelabs.developers.google.com/codelabs/android-training-livedata-viewmodel/#1   
	3. Part 2 https://codelabs.developers.google.com/codelabs/android-training-room-delete-data/#0
- Web Services
	1. Intro to Retrofit 2 https://zeroturnaround.com/rebellabs/getting-started-with-retrofit-2/ 
- Repository Pattern
	1. Tutorial about whole MVVM structure https://codelabs.developers.google.com/codelabs/build-app-with-arch-components/index.html?index=..%2F..index#0
- ViewModel
	1. Livedata - https://developer.android.com/topic/libraries/architecture/livedata
	2. ViewModel - https://developer.android.com/topic/libraries/architecture/viewmodel

### Libraries

```

	//Version definitions
    def retrofitVersion = "2.5.0"
    def nav_version = "2.1.0-alpha02"
    def lifecycle_version = "2.0.0"

    //Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofitVersion"
    implementation "com.squareup.retrofit2:converter-gson:$retrofitVersion"

    //Firebase Cloud Messaging
    implementation 'com.google.firebase:firebase-messaging:18.0.0'
    implementation 'com.google.firebase:firebase-core:16.0.9'

    //Navigation Architecture Components
    implementation "androidx.navigation:navigation-fragment:$nav_version"
    implementation "androidx.navigation:navigation-ui:$nav_version"

    //Butterknife
    implementation 'com.jakewharton:butterknife:10.1.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:10.1.0'

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"

    //Gauge Custom View
    implementation 'com.github.Pygmalion69:Gauge:1.5'

    //Recyclerview
    implementation 'androidx.recyclerview:recyclerview:1.0.0'

```

