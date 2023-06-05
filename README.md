# MyWordsDictionary - the gives wor meanings and allows user to Favorite words and maintain them in a separate personal list

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


Domain> Mappers > Mapper.kt  (comes after Data>Remote>DTOs) and other Remote package components
linking/mapping following items:
Definition, Meaning, WordData to Worddata and WordDataEntity



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



**Data**
Remote>Dto
DefinitionDTO - basic stuff : antonyms, definition, example, synonyms
MeaningDTO - antonyms, definitions form definitionsDto, partOfSpeech, synonyms
LicenceDto - name, url
PhoneticDto - audio, licence from licenceDto, sourceUrl, text
WordDataDto - word, phoneticDto, meaningDto, LicenceDto, sourceUrls
WordDataEntity - word, phonetic, meanings, sourceUrls, date (Java util Date)



**_Now that the back-end is complete, proceed to Presentation module_**

Presentation> WordData > WordDataItem:
DisplayWord - WordData + BookmarkedClicked
DisplayPhonetic - Text
DisplayMeanings - meanings picked up from PartOFSpeech and DisplayDefinitions using forEach
DisplayDefinitions further DisplayDefinition - definition + Example
DisplaysourceUrls - list of sourceUrls

Presentation > word_data >  WordDataScreen:
SearchBar() using with() - with() function ensures that the ViewModel object is not garbage collected while the SearchBar composable function is running. This way the wordQuery variable from main ViewModel is accessed, also the fetchWordData() is called.
Resulting Composable WordDataList() in lazyColumn that populates items list along with Favorite click button

Start building FavoriteWordScreen components:
Presentation has two folders - WordDataScreens and SavedWordsDataScreens
Start with ViewModel, which is aHiltViewModel, build in same way as WordDataViewModel
add files in use_case - GetSavedWords(pulls from SavedWordsRepo, uses Domain>utils>WordOrder sealed class objects), removeFromSaved. calls SavedWordState data class
Presentation > Saved_words > SavedWordsState data class with wordDataEntityItems (emptyList), filteresWordDataEntityItems(emptyList), isEmpty false, wordOrder descending
It calls getWords fun where JOB is cancelled() or if not null, it is Launched

So, the SavedWordsVM has getWords(), setFilteredList(), and removeWord()

Presentation > Saved_words > SavedWordsItem Composable
Again defining Composable funs DisplayWord(), DisplayPhonetic(), DisplayMeanings(), DisplaySourceUrls()

Presentation > Components
Defining two Composables - CustomRadioButton and OrderRadioButtons


DATA:
> Remote stuff first
DTO objs are already defined, need to defin the DictionaryAPIService - so that retrofit can know which data Endpoint to refer
retrofit will @GET EndPoint using a sus fun getWordData() using the @Path "word" which returns a list of WordDataDto objects
work in REMOTE is now DONE

moving to defining local ROOM data DAO objs. in DATA>LOCAL>DATA_SOURCE
defining SavedWordsDao and SavedWordsDatabase
Data>local>data_source>SavedWordsDao:
defining SQLite Queries

Data>Local>data_source> SavedWordsDatabase - local Room database
@Database name WordDataEntity
Applying abstract class and companion obj


Data > Local > Repo > SavedWordsRepoImpl



Data > LOCAL > Utils > Converters - different TypeConverter  - Gson stuff

moving to DATA > REPO where we define WordDataRepoImplemntation
as it extends WordDataRepo, implement memebers i.e. getWordData (only one member)

Missed defining Hilt injection for Disctionary class in CORE

Defining the Data Injection package with App Module Object which is annotated with @Module. Giving instructions to Dagger Hilt. It is installed as a Singleton Compoinent, meaning that its life is only valid till Singleton fun is accessed. Hence using the annotation @InstallIn

Provide a DictionaryAPIService fun that returns RetrofitBuilder from the remote API url
define othe rProvider funs


