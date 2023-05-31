# MyWordsDictionary
DRAFT - Readme

Steps: Manifest - Internet permissions

Dependencies: App Gradle - added kotlin-kapt and Dagger hilt plugins
Make sure JVM and kotlin compiler versions are compatible
Splash API dependency added

**Following dpendencies added:**
Compose Navigation
Material icons
Dagger Hilt
Retrofit API
Room local database
Also enabled  isExperimental = true in   compileOptions{}

Project Gradle - added compose - RECHECK
dagger hilt plugins

scaffold and navController States
using remember to create immutable states (user uneditable). Otherwise use mutableStateOf for mutable user-changeable states.

**TopAppBar()**
PENDING:
Drawer action in Menu (top left)
Fav icon TODO pending

COMPLETED ITEMS:
used Box to expand Text

**BottomAppBar()**
COMPLETED:
Icons and text for 3 internal destinations
onClick for each of the navigation buttons

Setting Navigation

**Domain:**

Domain > Repos Interfaces:
WordDataRepo which extends Kotlin Coroutine Flow for DataStatus
SavedWordsRepo interface with functions
getSavedWords which extends Kotlin coroutine Flow list for WordDataEntity(ROOM)
suspend fun insertIntoSaved
suspend fun deleteFromSaved
suspend fun isExistWord


Domain> Model > Entity > WordDataEntity - **ROOM Database**
@Entity
data class aka TABLE with rows - autoGenerate True, id, word,phonetic, meanings, sourceURLs, date
The Entity folder is dedicated to storing the data models that represent the structure and schema of the database tables. 

The "use case" folder helps to adhere to the Single Responsibility Principle by providing a dedicated location for implementing individual use cases or business operations

Domain > Use_case (Business Logic) > AddIntoSaved
calls SavedWordsRepo
suspend operator fun invoke, repo.insert wordDataEntity


Domain > Use_case > RemoveFromSaved
calls deleteFromSaved using a suspen operator function


Domain > Use_case > IsExistWord
calls SavedWordsRepo with a suspend operator fun invoke WORD

Domain > Use_case > GetWordData
gets data from WordDataRepo
and operator fun invoke - special Kotlin function that allows an object to be invoked as if it were a function



Domain > Model: several data classes
Definition - antonyms, definition, example, synonyms
Meaning - ListOf Definition, partOfSpeech
WordData - word, phonetic, listOf Meaning, sourceURLs, isSaved(favorited)


Domain> Mappers > Mapper.kt  (comes after DTOs) and other Remote package components

**Utils:**
Adding Helper class (parameterized with a generic type T) in Utils package - DataStatus (Success, Loading, Error), date, message in a sealed class


**Presentation** -> Starts with a ViewModel and defining dependent classes

Presentation > Word_data > WordDataState - data class wordDataItems, errorMessage, isLoading

Presentation > word_data > WordDataViewModel:
HiltViewModel - Inject Constructor - GetWordData, AddIntoSaved(calls SavedWordsRepo), RemoveFromSaved, IsExistWord
ViewModel is a class that is part of the Android Architecture Components. It is designed to store and manage UI-related data in a lifecycle-aware manner

_Within the WordViewModel class:_
instantiating State for wordQuery variable
State is saved asStateFlow()
and job coroutine
fun fetchWordData()







