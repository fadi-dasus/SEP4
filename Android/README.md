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

1. Review and import Model Classes (Ainis, Vladimir, Aleksandr);
2. Web Services with Retrofit (Ainis) 
3. ListRepository 
4. ViewModel
6. Navigation Architecture Components 
7. MeasurementRepository
8. Firebase Cloud Messaging
9. Expanding on fragments for report list, warning list, report itself

### Web API To Follow

- Base URL: https://localhost:8080/sep4/

*Room*
- /room/{id} - get individual room by ID 
- /roomAll - get all rooms

*CO2*
- /co2/{id} - gets individual CO2 by ID
- /co2all - gets all CO2

*Humidity*
- /humidity/{id} - gets individual Humidity by ID
- /humidityAll - gets all humidities

*Temperature*
- /temperature/{id} - get individual temperature by ID
- /temperatureAll - get all temperatures

*Warning*
- /warningAll - get all warnings

Sequence is linear!

1. Create Model Classes (Ainis, Vladimir, Aleksandr)  ✓
2. Room Database (Vladimir and Aleksandr)
	1. Simple Tutorial https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0
	2. Part 1 https://codelabs.developers.google.com/codelabs/android-training-livedata-viewmodel/#1   
	3. Part 2 https://codelabs.developers.google.com/codelabs/android-training-room-delete-data/#0
3 Web Services (Ainis) (Random data is provided using Math.Random)
	1. Intro to Retrofit 2 https://zeroturnaround.com/rebellabs/getting-started-with-retrofit-2/ 
4. Repository Pattern (Ainis, Vladimir Aleksandr)
	1. Tutorial about whole MVVM structure https://codelabs.developers.google.com/codelabs/build-app-with-arch-components/index.html?index=..%2F..index#0
5. ViewModel & ViewModelFactory
	ListViewModel Vladimir
	MeasurementViewModel Aleksandr
	ViewModelFactory Ainis
	1. Livedata - https://developer.android.com/topic/libraries/architecture/livedata
	2. ViewModel - https://developer.android.com/topic/libraries/architecture/viewmodel
6. InjectorUtils & AppExecutors (Ainis)
7. Activities
	RoomActivity (3 Text Views as of now)

### Libraries
- Retrofit2 & Retrofit2-Jackson-Converter
- RecyclerView

