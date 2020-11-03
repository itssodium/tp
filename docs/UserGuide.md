# Covigent - User Guide

1. [Introduction](#1-introduction)
1. [About this Guide](#2-about-this-guide)<br />
   2.1. [What's in Covigent](#21-what-is-in-covigent)<br />
   2.2. [Formatting in the Guide](#22-formatting-in-the-guide)<br />
1. [Getting Started](#3-getting-started)<br />
   3.1. [Setting Up](#31-setting-up)<br />
   3.2. [Using Covigent](#32-using-covigent)<br />
1. [Glossary](#4-glossary)
1. [Features](#5-features)<br />
    5.1. [Command Format](#51-command-format)<br />
    5.2. [Patients](#52-patients)<br />
          5.2.1. [Add a Patient: `addpatient`](#521-add-a-patient-addpatient)<br />
          5.2.2  [Delete a Patient: `deletepatient`](#522-delete-a-patient-deletepatient)<br />
          5.2.3  [Edit Patient Details: `editpatient`](#523-edit-patient-details-editpatient)<br />
          5.2.4  [Search Patients by Information: `searchpatient`](#524-search-patients-by-information-searchpatient)<br />
          5.2.5  [List all Patients: `listpatient`](#525-list-all-patients-listpatient)<br />
    5.3. [Room](#53-room)<br />
          5.3.1  [Initialise Rooms in Hotel: `initroom`](#531-initialise-rooms-in-hotel-initroom)<br />
          5.3.2  [Allocate Patient to Room: `allocateroom`](#532-allocate-patient-to-room-allocateroom)<br />
          5.3.3  [Search by Room Number: `searchroom`](#533-search-by-room-number-searchroom)<br />
          5.3.4  [Search for Room with Patient: `searchroom`](#534-search-for-room-with-patient-searchroom)<br />
          5.3.5  [List the Current Rooms: `listroom`](#535-list-the-current-rooms-listroom)<br />
          5.3.6  [Find the first free room: `findemptyroom`](#536-find-the-first-free-room-findemptyroom)<br />
    5.4 [Task](#54-task)<br />
          5.4.1  [Add a Task to a Room: `addtask`](#541-add-a-task-to-a-room-addtask)<br />
          5.4.2  [Delete a Task from a Room: `deletetask`](#542-delete-a-task-from-a-room-deletetask)<br />
          5.4.3  [Edit Task Description or Due Date: `edittask`](#543-edit-task-description-or-due-date-edittask)<br />
          5.4.4  [Remove Due Date from a Task: `edittask`](#544-remove-due-date-from-a-task-edittask)<br />
          5.4.5  [Search all Tasks before the Given Date: `searchtask`](#545-search-tasks-before-a-given-date-searchtask)<br />
          5.4.6  [List all Tasks: `listtask`](#546-list-all-tasks-listtask)<br />
    5.5  [View Help: `help`](#55-view-help-help)<br />
    5.6  [Exit Covigent: `exit`](#56-exit-covigent-exit)<br />
    5.7  [Autosave](#57-autosave)<br />
1. [Command Summary](#6-command-summary)
1. [FAQ](#7-faq)


--------------------------------------------------------------------------------------------------------------------

## 1. Introduction

Welcome to User Guide for our application, Covigent! Are you a manager of a quarantine facility searching for an application 
to manage the information of quarantined individuals or the tasks to be done by your staff? Your search ends here! 

Covigent is a desktop management application that helps to keep track of the information of quarantined individuals 
and the tasks to be done by the staff of the quarantined facility. The main features include:<br>

      1. Managing quarantined individuals information - Period of Stay, temperature, phone number etc.<br>
      2. Managing the rooms of the quarantine facility - Allocate quarantined individuals to rooms, search for a room, etc.<br>
      3. Managing the tasks to be done by each room - Add a task to a room, editing a task to the room, etc.<br>

As an application optimized for use with a keyboard rather than the mouse, you operate Covigent mainly by 
typing commands into a Command Box. If you can type quickly, Covigent can improve your efficiency in managing your patients and tasks instead of using traditional apps.
But wait! Don't forget our beautiful Graphical User Interface (GUI) too!
With our easy to navigate GUI, it has served it's purpose well as an interface that facilitates interaction with our application
through graphical icons. 

Getting interested? Jump to [Section 3, "Getting Started"](#3-getting-started) to get started.

This is what Covigent looks like:

<p align="center">
    <img src="images/ug/f1_ui.png">
    <br />
    <i>Figure 1. The Graphical User Interface for Covigent</i>
</p>

_Written by: Ming De_


--------------------------------------------------------------------------------------------------------------------

## 2. About this Guide

This guide gives you an overview of the features in Covigent and shows you how to get started using Covigent. 
Choose a link in the [Feature](#5-features) section to get a step-by-step instruction, and understand how to use Covigent. 

### 2.1 What is in Covigent

In our patient features, you can [add](#521-add-a-patient-addpatient), [delete](#522-delete-a-patient-deletepatient),
[edit](#523-edit-patient-details-editpatient), [search](#524-search-patients-by-information-searchpatient) for a patient,
or you can [list](#525-list-all-patients-listpatient) out all the patients in Covigent.

Moving on to our room features, you can [initialise](#531-initialise-rooms-in-hotel-initroom), [allocate](#532-allocate-patient-to-room-allocateroom),
[search](#533-search-by-room-number-searchroom) and [find](#536-find-the-first-free-room-findemptyroom) the rooms which you need.
If you want an overview of the rooms, you can [list](#535-list-the-current-rooms-listroom) out all the rooms in Covigent.

Next, for our task features, you can [add](#541-add-a-task-to-a-room-addtask), [delete](#542-delete-a-task-from-a-room-deletetask), 
[edit](#543-edit-task-description-or-due-date-edittask) and [search](#545-search-tasks-before-a-given-date-searchtask) for a task
and see it be displayed on our amazing GUI. If you want to see all the tasks, you can [list](#546-list-all-tasks-listtask) out all the tasks in Covigent.


Lastly, our miscellaneous features will ensure that you can seek [help](#55-view-help-help) if you are lost, or 
[exit](#56-exit-covigent-exit) the program when you are done with it. Our app also has an [autosave](#57-autosave) feature that allows you to save the data without manual command.


### 2.2 Formatting in the Guide

Note the following formatting used in this document:
* ![icon](images/ug/icon_info.png) This symbol indicates important information.

* ![icon](images/ug/italics.PNG) 
Italicised words are used to indicate examples of input that the user can key in.

* ![icon](images/ug/icon_keyword.png) 
A grey highlight (called a mark-up) indicates that this is a field or command
that can be typed into the command line and executed by Covigent.

* ![icon](images/ug/HyperLink_words.PNG) 
A light blue font color indicates that this is a Hyperlink that you can click on
and be transferred to the coresponding section in Covigent.

_Written by: Wai Lok_


--------------------------------------------------------------------------------------------------------------------

## 3. Getting Started

If you are tired of lengthy and problematic installation processes, Covigent is perfect for you.
The setup is minimal and can be completed in 4 simple steps. Follow the instructions below to try it out!

### 3.1 Setting Up

The following steps to set up Covigent are applicable to Windows, Mac OS X, and Linux.

1. Install _Java 11_ or a later version. The latest version of _Java_ can be found [here](https://java.com/en/download/).

1. Download the latest version of Covigent from [here](https://github.com/AY2021S1-CS2103T-W12-1/tp/releases). Look for the file `covigent.jar`.

1. Copy the file to the folder you want to use as the home folder of Covigent.

1. Double-click on _covigent.jar_ to start Covigent.

### 3.2 Using Covigent

Covigent has numerous features, including adding quarantined individuals, creating rooms, assigning tasks to rooms, and more.
Every feature has a corresponding command. Using a feature is as simple as typing a command in the command box (see Figure 2) and pressing Enter to execute it.

<p align="center">
    <img src="images/ug/f2_commandbox.png" width="800" height="100">
    <br />
    <i>Figure 2. Command Box of Covigent</i>
</p>

Some example commands you may try:

   * **`addpatient`** `n/John Doe t/37.4 d/20200910-20200924 p/98765432 a/35` : Adds a quarantined individual named _John Doe_ with age _35_, phone number _98765432_, period of stay _20200910-20200924_, and temperature _37.4_.
   * **`initroom`** `5` : Creates 5 rooms in the quarantine facility.
   * **`addtask`** `r/3 d/Restock supplies dd/20201230 2359` : Adds a task to room 3 with description _Restock supplies_ and due date _20201230 2359_.

For more details of each command, please refer to the section on [Section 5, Features](#5-features).

_Written by: Yee Hong_


--------------------------------------------------------------------------------------------------------------------

## 4. Glossary

* **Graphical User Interface**: A form of user interface that allows users to interact with electronic devices through graphical icons. <br />
* **Patient**: An individual who resides in the quarantine facility. <br />
* **Task**: A task to be completed by staff of the quarantine facility. <br />

_Written by: Yun Qing_

--------------------------------------------------------------------------------------------------------------------

## 5. Features

This section covers all the commands that you can type into the command box of Covigent. The commands are categorised into [patient features](#52-patients), [room features](#53-room) and [task features](#54-room). If it is the first time that you are using the command, we recommend that you refer to [Command Format](#51-command-format) to find out how to interpret the format of the commands.

_Written by: Yun Qing_

### 5.1 Command Format

**:information_source: Notes about the command format:** <br />
* Words in `UPPER_CASE` are the fields to be supplied by the user. <br />
  e.g. in `addpatient n/NAME`, `NAME` is a field which can be used as `addpatient n/John Doe`.

* Fields in square brackets are optional. <br />
  e.g `n/NAME [c/COMMENT]` can be used as `n/John Doe c/Is vegan` or as `n/John Doe`.

* Fields can be in any order. <br />
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If the same field is provided multiple times, only the last input for that field will be processed.<br />
  e.g. if you input `n/John Doe n/Mary Doe`, Covigent will only process `n/Mary Doe` and ignore `n/John Doe`. Similarly, if you input `n/John Doe t/37.4 n/Mary Doe t/36.5`, Covigent will interpret the fields provided as simply `n/Mary Doe t/36.5`.


### 5.2 Patients

This section contains all the commands related to patients. You can [add](#521-add-a-patient-addpatient), [delete](#522-delete-a-patient-deletepatient),
[edit](#523-edit-patient-details-editpatient), [search](#524-search-patients-by-information-searchpatient) for a patient, or you can [list](#525-list-all-patients-listpatient) out all the patients in Covigent. If you are unsure of how to interpret the command format, head back to [Command Format](#51-command-format) before executing the commands!

#### 5.2.1 Add a patient: `addpatient` 

You can use this command to add a patient with the following details: name, temperature, period of stay, phone number, age and comment.<br />

**Format:** `addpatient n/NAME t/TEMPERATURE d/PERIOD_OF_STAY p/PHONE_NUMBER a/AGE [c/COMMENT]`<br />

Field | Description
------------ | -------------
`NAME` | The name of the patient. It should preferably be the full name of the patient. The name should be less than 150 characters. 
`TEMPERATURE` | The temperature of the patient. It must be keyed in to 1 decimal place (e.g. 37.0 instead of 37) and must be within the range 32.0 to 41.0 degree celsius, both inclusive.
`PERIOD_OF_STAY` | The period of stay of the patient in the facility. It must be in the format _YYYYMMDD-YYYYMMDD_. Both dates must be valid and the start date must be before or equals to the end date.
`PHONE_NUMBER` | The phone number of the patient that the patient wishes to be contacted by.
`AGE` | The age of the patient, which is between 0 (inclusive) and 120 (exclusive).
`COMMENT` | An optional field that is used to indicate any special details of the patient such as dietary preferences or health conditions.

**:information_source: Important Information:** <br />
* Duplicate names are not allowed. If an entry of name _John Doe_ is recorded in Covigent, you should not add a patient of the name _John Doe_ again.
<br />

**Example(s):**
1. `addpatient n/Betsy Crowe t/36.5 d/20201001-20201014 p/91234567 a/19 c/Is asthmatic` A patient named _Betsy Crowe_ with temperature _36.5_, period of stay from _1 October 2020 to 14 October 2020_, phone number _91234567_, age _19_ and comment _Is asthmatic_ is added to Covigent.
<br />

**Step By Step Usage:** <br />
1. Navigate to the Patients tab under the navigation bar as shown in Figure 3.
<p align="center">
    <img src="images/ug/patienttab.png" width="380" height="300">
    <br />
   <i>Figure 3. Navigation to Patients tab</i>
</p>

2. Using the first example, key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/f4_addpatientcommand.png" width="700" height="150">
    <br />
   <i>Figure 4. <code>addpatient</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4. The result box displays the message shown in Figure 5 and the newly added patient can now be found in the list of patients in Covigent. 

5. To view the details of the newly added patient, click on the newly added patient in the patient list.
<p align="center">
    <img src="images/ug/f5_addpatientsuccess.png" width="620" height="400">
    <br />
    <i>Figure 5. A Successful Execution of <code>addpatient</code> command</i>
</p>

6. If you do not see the success message as shown in Figure 5, please repeat step 2 onwards.

_Written by: Yun Qing_

#### 5.2.2 Delete a patient: `deletepatient` 

You can use this command to delete the details of the existing patient identified by his/her name from Covigent.<br /> 

**Format:** `deletepatient NAME`<br />

Field | Description
------------ | -------------
`NAME` | The name of the patient to be deleted. It is case-insensitive and must match exactly with the name of the patient that was input into Covigent previously.

**:information_source: Important Information:** <br />
* If the patient to be deleted was allocated a room previously, the room will be updated to unoccupied in Covigent.
<br />

**Example(s):**
1. `deletepatient Mary Doe` The patient details of Mary Doe will be deleted from Covigent.
<br />

**Step By Step Usage:** <br />
1. Navigate to the Patients tab under the navigation bar as shown in Figure 6.
<p align="center">
    <img src="images/ug/patienttab.png" width="380" height="300">
    <br />
   <i>Figure 6. Navigation to Patients tab</i>
</p>

2. Using the first example, key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/f7_deletepatientcommand.png" width="700" height="150">
    <br />
   <i>Figure 7. <code>deletepatient</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4. The result box displays the message shown in Figure 8 and the deleted patient can no longer be found in the list of patients in Covigent.
<p align="center">
    <img src="images/ug/f8_deletepatientsuccess.png" width="620" height="400">
    <br />
    <i>Figure 8. A Successful Execution of <code>deletepatient</code></i>
</p>

5. If you do not see the success message as shown in Figure 8, please repeat step 2 onwards.

_Written by: Yun Qing_

#### 5.2.3 Edit Patient Details: `editpatient`

You can use this command to edit an existing patient's details in Covigent.

**Format**: `editpatient ORIGINAL_NAME [n/NEW_NAME] [t/TEMPERATURE] [d/PERIOD_OF_STAY] [p/PHONE_NUMBER] [a/AGE] [c/COMMENT]`<br />

Field | Description
------------ | -------------
`ORIGINAL_NAME` | The name of the patient whom details are to be edited. It must match exactly with the name of the patient that was input into Covigent previously. It is case-insensitive.
`NEW_NAME` | The new name of the patient. The new name must not already exist within Covigent and should be less than 150 characters. 
`TEMPERATURE` | The new temperature of the patient. It must be keyed in to 1 decimal place (e.g. 37.0 instead of 37) and must be within the range 32.0 to 41.0 degree Celsius, both inclusive.
`PERIOD_OF_STAY` | The new period of stay of the patient. It must be in the format _YYYYMMDD-YYYYMMDD_. Both dates must be valid and the start date must be before or equals to the end date.
`PHONE_NUMBER` | The new phone number of the patient.
`AGE` | The new age of the patient. Age should be between 0 (inclusive) and 120 (exclusive).
`COMMENT` | The new comments about the patient.

**:information_source: Important Information:** <br />
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
<br />

**Example(s):**
1. `editpatient john doe p/91234567` The phone number of the patient named John Doe will be updated to _91234567_.
1. `editpatient alex t/36.7 a/21 d/20200303-20200315` The temperature, age and period of stay of the patient named Alex will be updated to _36.7_, _21_ and _20200303-20200315_ respectively.

**Step By Step Usage:** <br />
1. Navigate to the Patients tab under the navigation bar as shown in Figure 9.
<p align="center">
    <img src="images/ug/patienttab.png" width="380" height="300">
    <br />
   <i>Figure 9. Navigation to Patients tab</i>
</p>

2. Using the first example, key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/f10_editpatientcommand.png" width="700" height="150">
    <br />
   <i>Figure 10. <code>editpatient</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4.  The result box displays the message shown in Figure 11 and the patient is edited in Covigent. 

5. The details of the newly edited patient will be shown in the details panel.
<p align="center">
    <img src="images/ug/f11_editpatientsuccess.png" width="620" height="400">
    <br />
    <i>Figure 11. A Successful Execution of <code>editpatient</code> command</i>
</p>

6. If you do not see the success message as shown in Figure 11, please repeat step 2 onwards.

_Written by: Ming De_

#### 5.2.4 Search Patients by Information: `searchpatient`

You can use this command to search patients that match the given criteria(name or a range of temperature) in Covigent.

**Format**: `searchpatient [n/NAME] [tr/TEMPERATURE_RANGE]`

Field | Description
------------ | -------------
`NAME` | The full name or the sub-name of the patient you want to look for. If the patient's name is "Alex Joe", then you must enter "Alex", "Joe" or "Alex Joe" to find him. You input is case-insensitive.
`TEMPERATURE_RANGE` | The temperature range that you want to look for. It is made up of two valid temperatures. A temperature must be keyed in to 1 decimal place (e.g. 37.0 instead of 37). The two temperature are linked using a dash "-". The `TEMPERATURE_RANGE` is inclusive of start and end temperatures. `tr/35.5-36.0` means a temperature range of 35.5-36.0 degree, celsius, both inclusive.

**:information_source: Important Information:** <br />
* Only one of the fields can be provided. If the field `n\name` is entered, you should not enter the field `tr/TEMPERATURE_RANGE`.<br /> 
* The two temperature you enter for field `tr/TEMPERATURE_RANGE` must both be valid, if one of the temperature is invalid, the search function will fail.<br /> 
<br />
**Example(s):**
1 `searchpatient n/john` Searches patients with names containing _john_.
1 `searchpatient tr/36.5-36.7` Searches patients within temperature range _36.5 to 36.7_ degree celsius, both inclusive.

**Step By Step Usage:**  <br />

1. Navigate to the Patients tab under the navigation bar as shown in Figure 12.
<p align="center">
    <img src="images/ug/patienttab.png" width="380" height="300">
    <br />
   <i>Figure 12. Navigation to Patients tab</i>
</p>

2. Before the search, this is what you see in the list of patient.
<p align="center">
    <img src="images/ug/patientuibeforesearch.PNG" width="380" height="300">
    <br />
   <i>Figure 13. Patient List before <code>searchpatient</code> command </i>
</p>

3. Using the second example, key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/searchpatientcommand.PNG" width="700" height="150">
    <br />
   <i>Figure 14. <code>searchpatient</code> command in Command Box</i>
</p>

4. Press `enter` to run the command.

5. With reference to Figure 15, the result box displays the message "Listed patient(s) matching the criteria.".

6. Now you can find Patients with a temperature between 36.5 and 36.7 degree celsius in the list of patients in Covigent.
<p align="center">
    <img src="images/ug/figure6_searchpatient.png" width="480" height="400">
    <br />
    <i>Figure 15. A Successful Execution of <code>searchpatient</code></i>
</p>

_Written by: Wai Lok_

#### 5.2.5 List all patients: `listpatient`

You can use this command to look at the list of all patients in the patient tab.

**Format**: `listpatient`

**Example(s)**:
1. `listpatient` Lists all patients that are present in Covigent.

**Step By Step Usage:**  <br />

1. Navigate to the Patients tab under the navigation bar as shown in Figure 16.
<p align="center">
    <img src="images/ug/patienttab.png" width="380" height="300">
    <br />
   <i>Figure 16. Navigation to Patients tab</i>
</p>

2. Key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/figure7_listpatientcommand.png" width="480" height="400">
    <br />
    <i>Figure 17. <code>listpatient</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4. Now you can find the full list of patient in Covigent.
<p align="center">
    <img src="images/ug/figure7_listpatient.png" width="480" height="400">
    <br />
    <i>Figure 18. A Successful Execution of <code>listpatient</code></i>
</p>

_Written by: Wai Lok_

### 5.3 Room

This section contains all the commands related to rooms. You can [initialise](#531-initialise-rooms-in-hotel-initroom), [allocate](#532-allocate-patient-to-room-allocateroom),[search](#533-search-by-room-number-searchroom) and [find](#536-find-the-first-free-room-findemptyroom) the rooms which you need.
If you want an overview of the rooms, you can [list](#535-list-the-current-rooms-listroom) out all the rooms in Covigent. If you are unsure of how to interpret the command format, head back to [Command Format](#51-command-format) before executing the commands!


#### 5.3.1 Initialise Rooms in Hotel: `initroom`

You can use this command to initialise a number of rooms in the quarantine facility to the app, if there was data given previously, they would 
be stored.

Format: `initroom NUMBER_OF_ROOMS`

Field | Description
----------|-------------
`NUMBER_OF_ROOMS` | The number of rooms you wish to have in hotel

**:information_source: Important Information:** <br />
* If the number of rooms is less than the number of patients error is thrown when decreasing the number of existing rooms.
* Adds `NUMBER_OF_ROOMS` rooms into the hotel system, if there were previously added information that information for respective rooms will still be there.
<br />

**Example(s):**
1. `initroom 123`. 123 rooms are initialised in Covigent.
1. `initroom 400`. 400 rooms are initialised in Covigent.

**Step By Step Usage:** <br />
1. Navigate to the Rooms tab under the navigation bar as shown in Figure ??.
<p align="center">
    <img src="images/ug/roomstab.png" width="380" height="300">
    <br />
   <i>Figure ??. Navigation to Rooms tab</i>
</p>

2. Using the first example, key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/initroomcommand.png" width="380" height="200">
    <br />
   <i>Figure ??. <code>initroom</code> command in Command Box</i>
</p>
3. Press `enter` to run the command
4. The result box shows a success message "Initialise the number of rooms to 400 rooms in the application.".
<p align="center">
    <img src="images/ug/figure8_initroom.png" width="550" height="400">
    <br />
    <i>Figure 8. A Successful Execution of <code>initroom</code></i>
</p> 

_Written by: Noorul Azlina_

#### 5.3.2 Allocate Patient to Room: `allocateroom`

You can use this command to allocate a patient to a room.

**Format**: `allocateroom ROOM_NUMBER n/PATIENT_NAME`

Field | Description
----------|-------------
`ROOM_NUMBER` | The room number of the room of which the patient is to be allocated to. A room with the `ROOM_NUMBER` must already exist within Covigent.
`PATIENT_NAME` | The name of the patient to be allocated to the room. It is case-sensitive but must match exactly with the name of the patient that was input into Covigent previously.

**:information_source: Important Information:** <br />
* To remove a patient from the room, input the patient name as "-". Refer to the example below for more clarity.
<br />

**Example(s):**
1. `allocateroom 1 n/john doe`. The patient named John Doe will be allocated to Room #1.
1. `allocateroom 1 n/-`. The previous patient will be removed from Room #1.

**Step By Step Usage:** <br />
1. Navigate to the Rooms tab under the navigation bar as shown in Figure ??.
<p align="center">
    <img src="images/ug/roomstab.png" width="380" height="300">
    <br />
   <i>Figure ??. Navigation to Rooms tab</i>
</p>

2. Using the first example, key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/allocateroomcommand.png" width="700" height="150">
    <br />
   <i>Figure 7. <code>allocateroom</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4. With reference to Figure ??, the result box displays the message "_Allocated Room: Room Number: 1 Patient: Alex Yeoh 
Temperature: 36.7 Period of stay: 08 Sep 2020 to 18 Sep 2020 Phone: 912345678Age: 23 Comment: - TaskList: -_" 
The room with the newly allocated patient is shown in the room details panel.
<p align="center">
    <img src="images/ug/allocateroomsuccess.png" width="620" height="400">
    <br />
    <i>Figure ??. A Successful Execution of <code>allocateroom</code> for Room Number</i>
</p>

5. If you do not see the success message as shown in Figure ??, please repeat step 2 onwards.

_Written by: Ming De_

#### 5.3.3 Search by Room Number: `searchroom` 

You can use this command to search for the room details with the specified room number.

**Format:** `searchroom r/ROOM_NUMBER`

Field | Description
----------|-------------
`ROOM_NUMBER` | The room number of the room to be searched for, which is a positive integer. The room number should be present in the list of rooms in Covigent.

**Example(s):**
1. `searchroom r/6` The room details of room number 6 will be searched.

**Step By Step Usage:** <br />
1. Navigate to the Rooms tab under the navigation bar as shown in Figure ??.
<p align="center">
    <img src="images/ug/roomstab.png" width="380" height="300">
    <br />
   <i>Figure ??. Navigation to Rooms tab</i>
</p>

2. Using the first example, key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/searchroomnumbercommand.png" width="700" height="150">
    <br />
   <i>Figure 7. <code>searchroom</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4. The result box displays the message shown in Figure ?? and the room with the specified room number is shown in the room details panel.
<p align="center">
    <img src="images/ug/searchroomnumbersuccess.png" width="620" height="400">
    <br />
    <i>Figure ??. A Successful Execution of <code>searchroom</code> for Room Number</i>
</p>

5. If you do not see the success message as shown in Figure ??, please repeat step 2 onwards.

_Written by: Yun Qing_

#### 5.3.4 Search for Room with Patient: `searchroom` 

You can use this command to search for the room that the specified patient is residing in. 

**Format:** `searchroom n/NAME`

Field | Description
----------|-------------
`NAME` | The name of the patient whose room you are looking for. It is case-insensitive and must match exactly with the name of the patient that was input into Covigent previously.

**Example(s):**
1. `searchroom n/Mary Doe` The room details of the room that Mary Doe resides in will be searched.

**Step By Step Usage:** <br />
1. Navigate to the Rooms tab under the navigation bar as shown in Figure ??.
<p align="center">
    <img src="images/ug/roomstab.png" width="380" height="300">
    <br />
   <i>Figure ??. Navigation to Rooms tab</i>
</p>

2. Using the first example, key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/searchroompatientcommand.png" width="700" height="150">
    <br />
   <i>Figure ??. <code>searchroom</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4. The result box displays the message shown in Figure ?? and the room that the specified patient resides in is shown in the room details panel.
<p align="center">
    <img src="images/ug/searchroompatientsuccess.png" width="620" height="400">
    <br />
    <i>Figure ??. A Successful Execution of <code>searchroom</code> for Patient</i>
</p>

5. If you do not see the success message as shown in Figure ??, please repeat step 2 onwards.

_Written by: Yun Qing_

#### 5.3.5 List the Current Rooms: `listroom`

You can use this command to list all the rooms in the hotel together with information of whether the room is occupied or not.

Format: `listroom` All the rooms in Covigent.

**:information_source: Important Information:** <br />
* If there are no rooms, then no rooms will be mentioned and informs user to initialize rooms using the `initroom` command.
* You need at least one room for this command to work.<br />
<br />

**Step By Step Usage:** <br />
1. Navigate to Rooms tab under the navigation bar as shown in Figure ??
<p align="center">
    <img src="images/ug/roomstab.png" width="550" height="400">
    <br />
    <i>Figure 12. A Successful Execution of <code>listroom</code></i>
</p>
2. Next, type the command `listroom` in the command box as shown below
<p align="center">
    <img src="images/ug/listroomcommand.png" width="550" height="200">
    <br />
    <i>Figure ?? <code>listroom</code> command in Command Box</i>
</p>
3. Press `enter` to run the command
4. The result box shows a success message "All rooms are listed."
<p align="center">
    <img src="images/ug/figure12_listroom.png" width="550" height="400">
    <br />
    <i>Figure 12. A Successful Execution of <code>listroom</code></i>
</p>

_Written by: Noorul Azlina_

#### 5.3.6 Find the First Free Room: `findemptyroom`

You can use this command to find the room with the lowest room number that is free for use.

Format: `findemptyroom` The unoccupied room in Covigent with the lowest room number will be displayed on UI.

**:information_source: Important Information:** <br />
* If there are no empty rooms then an error message informing hotel staff is mentioned.
<br />

**Step By Step Usage:** <br />

1. Navigate to Rooms tab under the navigation bar as shown in Figure ??
<p align="center">
    <img src="images/ug/roomstab.png" width="550" height="400">
    <br />
    <i>Figure ??. A Successful Execution of <code>listroom</code></i>
</p>
2. Next, type the command `findemptyroom` in the command box as shown below
<p align="center">
    <img src="images/ug/findemptyroomcommand.png" width="550" height="200">
    <br />
    <i>Figure ??. <code>allocateroom</code> command in Command Box</i>
</p>
3. Press `enter` to run the command
4. The result box shows a success message that "Room Number 4 is empty"

<p align="center">
    <img src="images/ug/figure13_findemptyroom.png" width="550" height="400">
    <br />
    <i>Figure ??. A Successful Execution of <code>findemptyroom</code></i>
</p> 

_Written by: Noorul Azlina_

### 5.4 Task

This section contains all the commands related to tasks. You can [add](#541-add-a-task-to-a-room-addtask), [delete](#542-delete-a-task-from-a-room-deletetask), 
[edit](#543-edit-task-description-or-due-date-edittask) and [search](#545-search-tasks-before-a-given-date-searchtask) for a task and see it be displayed on our amazing GUI. If you want to see all the tasks, you can [list](#546-list-all-tasks-listtask) out all the tasks in Covigent. If you are unsure of how to interpret the command format, head back to [Command Format](#51-command-format) before executing the commands!

#### 5.4.1 Add a task to a room: `addtask`

You can use this command to add a task to a room. The task has the following details: description and due date.

Format: `addtask r/ROOM_NUMBER d/DESCRIPTION [dd/DUE_DATE]`

Field | Description
------------ | -------------
`ROOM_NUMBER` | The room number of the room to which you want to add the task. It refers to the number displayed beside each room under the list of rooms. An example of the room number highlighted in red: <br /><img src="images/ug/icon_roomnumber.png" width="250" />
`DESCRIPTION` | The description of the task. It can be related to the patient in the room, e.g. _Call the patient_; or related to the room, e.g. _Restock the supplies in this room_.
`DUE_DATE` | An optional field that is used to indicate by what date and time should the task be completed. It can in any of the following formats: <br /><ul><li>_YYYYMMDD_ \| e.g. 20210131</li><li>_YYYYMMDD HHmm_ \| 20210131 2359</li><li>_D/M/YYYY_ \| e.g. 31/1/2021 or 31/01/2021</li><li>_D/M/YYYY HHmm_ \| e.g. 31/1/2021 2359 or 31/01/2021 2359</li></ul>

**:information_source: Important Information:** <br />
* `DUE_DATE` defaults to `-` if you leave out the field, i.e. due date is not applicable.
* If you do not provide the time for a `DUE_DATE`, it defaults to 0000 (12am).
<br />

**Example(s):**
1. `addtask r/5 d/Remind patient to change bedsheets.` A task with description _Remind patient to change bedsheets._ is added to Room #5.
1. `addtask r/1 d/Running low on masks and needs to be restocked. dd/12/1/2021` A task with description _Running low on masks and needs to be restocked._ and due date _12 Jan 2021 0000_ is added to Room #1.

**Step By Step Usage:** <br />
* Using the first example, the result box displays the message _New Task added to Room 5. Description: Remind Alice to change bedsheets. Due Date: -_.
* The newly added task can now be found in Room #5.
* The newly added task can now be found in the list of tasks in Covigent.
* Figure 14 shows an example of a successful execution.
<p align="center">
    <img src="images/ug/figure14_addtask.png" width="550" height="400">
    <br />
    <i>Figure 14. A Successful Execution of <code>addtask</code></i>
</p>

_Written by: Yee Hong_

#### 5.4.2 Delete a task from a room: `deletetask`

You can use this command to delete an existing task from a room.

Format: `deletetask r/ROOM_NUMBER t/TASK_NUMBER`

Field | Description
------------ | -------------
`ROOM_NUMBER` | The room number of the room from which you want to delete the task. It refers to the number displayed beside each room under the list of rooms. An example of the room number highlighted in red: <br /><img src="images/ug/icon_roomnumber.png" width="250" />
`TASK_NUMBER` | The task number of the task to be deleted. It refers to the number displayed beside each task in the details panel for rooms. An example of the task number highlighted in red: <br /><img src="images/ug/icon_tasknumber.png" width="250" />

**:information_source: Important Information:** <br />
* Once you delete a task, the `TASK_NUMBER` of the remaining tasks changes accordingly. Figure 15 illustrates how Task 3 is updated to Task 2 after the original Task 2 is deleted.
<p align="center">
    <img src="images/ug/figure15_changingtasknumber.png" height="320">
    <br />
    <i>Figure 15. Task Number Changing after <code>deletetask</code></i>
</p>
<br />

**Example(s):**
1. `deletetask r/5 t/1` The first task (Task 1) of Room #5 is deleted.

**Step By Step Usage:** <br />
* The result box displays the message _Task 1 deleted from Room 5._, followed by the description and due date of Task 1.
* Task 1 is no longer in Room #5.
* For tasks that come after Task 1, the `TASK_NUMBER` is decreased by 1. E.g. The previous Task 4 will become Task 3.
* Task 1 is no longer in the list of tasks in Covigent.
* Figure 16 shows an example of a successful execution.
<p align="center">
    <img src="images/ug/figure16_deletetask.png" width="550" height="400">
    <br />
    <i>Figure 16. A Successful Execution of <code>deletetask</code></i>
</p>

_Written by: Yee Hong_

#### 5.4.3 Edit Task Description or Due Date: `edittask`

You can use this command to edit the description or due date of an existing task in a room.

Format: `edittask r/ROOM_NUMBER t/TASK_NUMBER [d/DESCRIPTION] [dd/DUE_DATE]`

Field | Description
------------ | -------------
`ROOM_NUMBER` | The room number of the room from which you want to edit the task. It refers to the number displayed beside each room under the list of rooms. An example of the room number highlighted in red: <br /><img src="images/ug/icon_roomnumber.png" width="250" />
`TASK_NUMBER` | The task number of the task to be edited. It refers to the number displayed beside each task in the details panel for rooms. An example of the task number highlighted in red: <br /><img src="images/ug/icon_tasknumber.png" width="250" />
`DESCRIPTION` | The description of the task. It can be related to the patient in the room, e.g. _Call the patient_; or related to the room, e.g. _Restock the supplies in this room_. 
`DUE_DATE` | An optional field that is used to indicate by what date and time should the task be completed. It can in any of the following formats: <br /><ul><li>_YYYYMMDD_ \| e.g. 20210131</li><li>_YYYYMMDD HHmm_ \| 20210131 2359</li><li>_D/M/YYYY_ \| e.g. 31/1/2021 or 31/01/2021</li><li>_D/M/YYYY HHmm_ \| e.g. 31/1/2021 2359 or 31/01/2021 2359</li></ul>

**:information_source: Important Information:** <br />
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* If you do not provide the time for a `DUE_DATE`, it defaults to _0000_ (12am).
<br />

**Example(s):**
1. `edittask r/3 t/1 d/Return a call to the patient. dd/12/1/2021 1500` The description and due date of the first task (Task 1) in Room #3 are updated to _Return a call to the patient._ and _12 Jan 2021 1500_ respectively.
1. `edittask r/2 t/2 dd/12-1-2021` The due date for the second task (Task 2) of Room #2 is updated to _12 Jan 2021 0000_.

**Step By Step Usage:** <br />
* Using the first example, the result box displays the message _Task 1 edited from Room 3. Description: Return a call to the patient. Due Date: 12 Jan 2021 1500_.
* The details panel for Room #3 shows the updated description and due date of Task 1.
* The list of tasks in Covigent shows the updated description and due date of Task 1.
* Figure 17 shows an example of a successful execution.
<p align="center">
    <img src="images/ug/figure17_edittask.png" width="550" height="400">
    <br />
    <i>Figure 17. A Successful Execution of <code>edittask</code> to Edit Task Description and Due Date</i>
</p>

_Written by: Yee Hong_

#### 5.4.4 Remove Due Date from a Task: `edittask`

You can use this command to remove a due date from a task in a room.

Format: `edittask r/ROOM_NUMBER t/TASK_NUMBER dd/-`

Field | Description
------------ | -------------
`ROOM_NUMBER` | The room number of the room from which you want to edit the task. It refers to the number displayed beside each room under the list of rooms. An example of the room number highlighted in red: <br /><img src="images/ug/icon_roomnumber.png" width="250" />
`TASK_NUMBER` | The task number of the task from which you want to remove the due date. It refers to the number displayed beside each task in the details panel for rooms. An example of the task number highlighted in red: <br /><img src="images/ug/icon_tasknumber.png" width="250" />
`-` | A `-` indicates the removal of a due date. 

**:information_source: Important Information:** <br />
* Existing values will be updated to the input values.
* This is only one feature of the `edittask` command. Refer to the full command [here](#543-edit-task-description-or-due-date-edittask).
<br />

**Example(s):**
1. `edittask r/3 t/1 dd/-` The due date of the first task (Task 1) in Room #3 is removed, i.e. set to `-`.

**Step By Step Usage:** <br />
* The result box displays the message _Task 1 edited from Room 3._ followed by the current description of Task 1 and _Due Date: -_.
* The details panel for Room #3 shows that Task 1 no longer has a due date.
* The list of tasks in Covigent shows that Task 1 of Room #3 no longer has a due date.
* Figure 18 shows an example of a successful execution.
<p align="center">
    <img src="images/ug/figure18_removeduedate.png" width="550" height="400">
    <br />
    <i>Figure 18. A Successful Execution of <code>edittask</code> to Remove Due Date</i>
</p>

_Written by: Yee Hong_

#### 5.4.5 Search Tasks before a Given Date: `searchtask`

You can use this command to search all tasks before a date in Covigent.

**Format**: `searchtask dd/DUE_DATE`

Field | Description
----------|-------------
`DUE_DATE` | The due date you are looking for. It can in any of the following formats: <br /><ul><li>_YYYYMMDD_ \| e.g. 20210131</li><li>_YYYYMMDD HHmm_ \| 20210131 2359</li><li>_D/M/YYYY_ \| e.g. 31/1/2021 or 31/01/2021</li><li>_D/M/YYYY HHmm_ \| e.g. 31/1/2021 2359 or 31/01/2021 2359</li></ul>

**:information_source: Important Information:** <br />
* If the time `HHmm` is not specified for a due date, it defaults to 0000 (12am).
<br />

**Example(s)**:
1. `searchtask dd/12/1/2021` Search all tasks before and including 12 January 2021 0000.

**Step By Step Usage:** <br />
1. Navigate to the Tasks tab under the navigation bar as shown in Figure 60.
<p align="center">
    <img src="images/ug/navigatetotask.PNG" width="380" height="300">
    <br />
   <i>Figure 60. Navigation to Tasks tab</i>
</p>

2. Using the example,  key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/searchtaskcommand.PNG" width="700" height="150">
    <br />
   <i>Figure 61. <code>searchtask</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4. With reference to Figure 62, the result box displays the message, "Tasks before the due date found.".

5. Now you can find tasks before and including 12 January 2021 0000 can now be found in the list of tasks in Covigent.
<p align="center">
    <img src="images/ug/searchtask.PNG" width="480" height="400">
    <br />
    <i>Figure 62. A Successful Execution of <code>searchtask</code></i>
</p>

_Written by: Wai Lok_

#### 5.4.6 List all Tasks: `listtask`

You can use this command to look at the list of all tasks in the task tab.

**Format**: `listtask`

**Example(s)**:
1. `listtask` Lists all tasks that are present in Covigent.

**Step By Step Usage:**  <br />

1. Navigate to the Tasks tab under the navigation bar as shown in Figure 63.
<p align="center">
    <img src="images/ug/navigatetotask.PNG" width="380" height="300">
    <br />
   <i>Figure 63. Navigation to Tasks tab</i>
</p>

2. Key in the command into the command box as shown below.
<p align="center">
    <img src="images/ug/listtaskcommand.PNG" width="480" height="400">
    <br />
    <i>Figure 64. <code>listtask</code> command in Command Box</i>
</p>

3. Press `enter` to run the command.

4. Now you can find the full list of patient in Covigent.
<p align="center">
    <img src="images/ug/listtask.PNG" width="480" height="400">
    <br />
    <i>Figure 18. A Successful Execution of <code>listtask</code></i>
</p>

_Written by: Wai Lok_

### 5.5 View help: `help`

If you encounter any issues using Covigent and need to access this user guide again, simply key in `help` into the command box.

**Format:** `help`

**Step By Step Usage:**  <br />

1. Key in the command into the command box as shown below.
2. Press `enter` to run the command.
3. The result box displays the message as shown in Figure xx.
<p align="center">
    <img src="images/ug/helpresultdisplay.png" width="750" height="150">
    <br />
    <i>Figure xx. Result display box</i>
</p>

4. A new help window appears.
<p align="center">
    <img src="images/ug/helpwindow.png" width="550" height="100">
    <br />
    <i>Figure xx. Help window</i>
</p>

_Written by Yun Qing_

### 5.6 Exit Covigent: `exit`

You can use this command to exit from Covigent.

**Format:** `exit`

**Step By Step Usage:**<br />
1. Key in the command into the command box.
2. Press `enter` to run the command.
3. Covigent exits and closes.

_Written by: MingDe_

### 5.7 Autosave

Covigent data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


--------------------------------------------------------------------------------------------------------------------

## 6. Command Summary 

Action | Format, Examples
--------|------------------
**Add Patient** | `addpatient n/NAME t/TEMPERATURE d/PERIOD_OF_STAY p/PHONE_NUMBER a/AGE [c/COMMENT]` <br /> e.g., addpatient n/Betsy Crowe t/36.5 d/20201001-20201014 p/91234567 a/19 c/Is asthmatic
**Delete Patient** | `deletepatient NAME` <br /> e.g., deletepatient Mary Doe
**Edit Patient** | `editpatient NAME [n/NAME] [t/TEMPERATURE] [d/PERIOD_OF_STAY] [p/PHONE_NUMBER] [a/AGE] [c/COMMENT]`<br /> e.g., editpatient James Lee t/36.5
**Search Patient** | `searchpatient [n/NAME] [tr/TEMPERATURE_RANGE]` <br /> e.g., searchpatient tr/36.5-36.7
**List Patients** | `listpatient`<br />
**Initialise Room** | `initroom NUMBER_OF_ROOMS` <br /> e.g., initroom 123
**Allocate Patient to Room** | `allocateroom ROOM_NUMBER n/NAME` <br /> e.g., allocateroom 5 n/David Li
**Search by Room Number** | `searchroom r/ROOM_NUMBER`<br /> e.g., searchroom r/15
**Search for Room with Patient** | `searchroom n/NAME`<br /> e.g., searchroom n/Jane Doe
**List Rooms** | `listroom` <br />
**Find Empty Room** | `findemptyroom` <br />
**Add Task to Room** | `addtask r/ROOM_NUMBER d/DESCRIPTION [dd/DUE_DATE]` <br /> e.g., addtask d/Running low on masks and needs to be restocked. r/1 dd/12/1/2021 
**Delete Task from Room** | `deletetask r/ROOM_NUMBER t/TASK_NUMBER` <br /> e.g., deletetask r/1 t/3
**Edit Task Description or Due Date** | `edittask r/ROOM_NUMBER t/TASK_NUMBER [d/DESCRIPTION] [dd/DUE_DATE]` <br /> e.g., edittask r/1 t/3 dd/12/1/2021 1500
**Remove Due Date from a Task** | `edittask r/ROOM_NUMBER t/TASK_NUMBER dd/-` <br /> e.g., edittask r/1 t/3 dd/-
**Search Task** | `searchtask dd/DUE_DATE` <br /> e.g., searchtask dd/12/1/2021
**Help** | `help`
**Exit** | `exit`

_Written by: Yun Qing_


--------------------------------------------------------------------------------------------------------------------

## 7. FAQ

**Q**: Why does the output sometimes appear red and sometimes black?<br />
**A**: If the command input is given in the wrong format, then the output is given in red. Also the correct format for the particular command is given.<br /> 
        
        Example:<br />
        Invalid command format! 
        Please give the number of digits in numbers
        Example: addRooms 200

**Q**: Will data be stored in the system after closing the app?<br />
**A**: The data is stored in the hard disk and therefore would not be deleted even if you close the app

**Q**: How do I look at all the rooms and patient when only one is being displayed after commands such as `findroom`?<br />
**A**: Use the command `listroom` for rooms and `listpatient` for patients.

**Q**: What should I do if nothing happens when I double click the Jar file?<br />
**A**: Open Terminal(Mac)/Command Prompt(Windows) . Type `cd [PATH TO DIRECTORY CONTAINING .JAR FILE]` . Type java `-jar covigent.jar` to run the application.

_Written by: Noorul Azlina_<br />
