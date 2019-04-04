##Development plan

###Phases

	####Minimum Viable Product (Mandatory)
		- Activity which displays CO2, Temperature, Humidity
		- MVVM (ViewModel & LiveData, Repository)
		- Room Database
		- Web Services

	####Expanded Minimum Viable Product (Optional)
		- Room choice
		- Authorization
		- Warning and Report lists activities with nice charts

###Tasks

	**Sequence is linear!

	1. Create Model Classes (Ainis, Vladimir, Aleksandr)
	2.1 Room Database (Vladimir and Aleksandr)
		_Resources
		1. Simple Tutorial https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0
		2. Part 1 https://codelabs.developers.google.com/codelabs/android-training-livedata-viewmodel/#1
		3. Part 2 https://codelabs.developers.google.com/codelabs/android-training-room-delete-data/#0
	2.2 Web Services (Ainis) (Random data is provided using Math.Random)
		_Resources_
		1. Intro to Retrofit 2 https://zeroturnaround.com/rebellabs/getting-started-with-retrofit-2/ 
	3. Repository Pattern (Ainis, Vladimir Aleksandr)
		_Resources_
		1. Tutorial about whole MVVM structure https://codelabs.developers.google.com/codelabs/build-app-with-arch-components/index.html?index=..%2F..index#0
	4. ViewModel & ViewModelFactory
		ListViewModel Vladimir
		MeasurementViewModel Aleksandr
		ViewModelFactory Ainis
		_Resources_
		1. Livedata - https://developer.android.com/topic/libraries/architecture/livedata
		2. ViewModel - https://developer.android.com/topic/libraries/architecture/viewmodel
	5. InjectorUtils & AppExecutors (Ainis)
	6. Activities
		RoomActivity (3 Text Views as of now)

