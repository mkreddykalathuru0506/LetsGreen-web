# LetsGreen
This application is for planting and monitoring trees.

My App should have 
 - Check app should be connected to internet or not, if not connected/ disconnected then show the pop up to ask user connect internet.

First Screen : WelcomeActivity
   - It should have  
       - Animation video
	   - Scrolling animated images
	   - Show the app availability areas so that user can decide.
	   - Option to register/login
	   - If click on option it should redirect to 

Registration Screen (Screen1):
   - 
   - Fill the form and submit.
   - Once click on submit, it should call the rest end point,
      - if response successfull then redirects to login page and ask to login.
	  - else Show the error message.
	  - Fallow the basic rules like check user is already present etc.

login screen(screen 2):
   - Login page should have options for 
    - Login with otp
	- Login with user id and password
	- login with pin
	- login with biometrics.
	- Fallow  and imple login scenarios.
	- It should also connect to db to check the role of the user.
	- Based on role Home page will be changed.
	- If role id Admin then redirect to Admin home screen.
	- If role id Admin then redirect to Admin home screen.
   	
	
User Home screen (screen 3):
==============================
These are components should be there
  1. Top Bar
    left side
     - Profile Icon : Once clicks on it, it should open profile details screen.
	 - Mandal and village name
	 
	Right side 
	 - Scan QR Code: Open screen to scan, if qr is matching then it show seperate screen for that.
	 - Notification bell: once click this it will open the Notifications list screen.
	 - Help icon : Once click on this it will show the app contact details.
	 
		  
	 
2.Tree management section: This section has below options:
------------------------------------------------------------

1.Book a tree:  
----------------
 - When user select this option a seperate screen will open which will have
 - User can see the list available trees in nearest nursery, pics also he can see.
 - Filter should be there for tree list like catagiry, Age, height etc.
 - user can select the tree or select multiple trees and select location where he want to plant and select the 
    time and date in the calender when he want to plant.
 - Once submitted tree booking service will call .
 
 
2. My bookings:
 -------------
 - Status image should be shown booking - aapointment - pick up - planted  should be shown on each tree.
 - Show the list of bookings .
 - filter it by date.
 - Booking will be deleted if not user picked up the tree from nursery.
 - If user clicked on particular booking,it will redirects to Booking details screen.

		Booking details:
		-----------------
		 - Show the booking details like trees, appointment details.
		 - User can delete the trees, add the trees from booking.
		 - if user cancel the booking then appointment will be deleted automatically
		 
		 
		 Appointment details:
		 ---------------------
		 - Show the appointment like nursery address, appointment date.
		 - user can update the appointment date/delete an appointment.
		 
  
3. My appointments:
 ---------------
 - This will show the appointment list.
 - Filter it by date , ne, old.
 - Book an appointment with nursery.
 - edit,delete  options will be there for each appointments, date can be updated.
 - once appointment updated, update appointment service will be called and sent notification.
 			

4.Locate my tree:
--------------
- After plant a tree user will mark his status as completed and update the pics.
  NM will get the notification and updated in  cloud.
- After planting he should fill the Planting form where User should tag the geo location etc.
- If Admin did not get the filled form with in same day, admin can raise a request to check whether planted r not.
- If user did not plant that tree NM will get the reason and and update in planting history and follow up him to plant next day.

5.Scan the tree:
--------------------
   - Scan the tree for planting history(Default)   
   - Scan the tree for medical history-- based on the role
   - Scan the tree for watering history---based on the role
   - If user select this option then QR scan screen will open and user can scan the QR code which is tagged to the  plant.   
   - First check whether that user have access to QR code service,
   -  Plant details  will be shown in different  screen where user  can check the plant details,owner details,
      health report and watering report etc.
	  
5.Nearest trees:
----------------
- When user selects this option,a seperate screen will open where user can see a Map with all location tags which are near to his current location.
- If user is still working in the organisation then he can select each loc tag and he can see all the plant details.
- If user is not working now then he can see only loc tags.

6.My trees:
-----------
- User can see list of trees, details and locate option will be there.
- User can see the health option in details, it will re direct to tree current health, Health history.
- User can see a Map with all location tags which are planted by him.
- If user is still working in the organisation then he can select each loc tag and he can see all the plant details.
- If user is not working now then he can see only loc tags.


Nursery manager screen (screen 5)
=================================

Dash board:
--------------
Visualizing the data of Nursery.


Tree management:
-------------
1.upcoming trees
- NM Can see the list of Trees coming to  in Nursery picked up by users.
- If clicks on each tree it will open the tree details. 
- NM can update the list if stock is already there.

2.Get the tree.
 - NM need to add the trees into Nursery,call create tree.
 

3.Bookings:

After 3rd step:
  - List of bookings, NM can filter by date, by appointment date, By planting loc, By user.
  - Once open one booking, It will show the booking details where he can approve/reject the booking.
  - Once click on approve , user will get the otp/ biometric validation once validated, one tree code ie qr r tree planting
    code will be generated and stored in db.
  -  NM can print that code and tag to that tree/ update in system and tree will be given to user.
  - After get the plants from the NM,it will be planted.
  - Booking Status will be changed to picked up.
  
4.Trees:

- NM Can see the list of Trees available in Nursery.
- If clicks on each tree it will open the tree details.
- NM can delete/update the details of each tree.

5.Booked trees.

- NM Can see the list of Trees available in Nursery booked by users.
- If clicks on each tree it will open the tree details.

6.Picked up trees.

- NM Can see the list of Trees available in Nursery picked up by users.
- If clicks on each tree it will open the tree details.

7.planted trees.

- NM Can see the list of Trees available in Nursery picked up by users.
- If clicks on each tree it will open the tree details.

8.my events


User Mnagement:
--------------
1.Add user
2. My users
3.contact user

 
  
Event manager (screen 6)
=========================

Dashboard
----------
Visualization of all events


Event management:
-----------------

1.Schedule event
  - post a new event , send a notification to location related users. 
  
2.my events
- Show the liast of events.
- EM can select each event and see the details of each event .
- EM can update the pics and videos after event completed with in the same day.
- EM should take the pics and videos through app only, once took the pics it wl upload the data.
- Filter by date, place etc.


3.Near by events
- Show the near by events.

4.upcoming events

- Show the upcoming events


5.Locate an event

- Show the event loc details



Health manager (screen 7)
==========================

Dashboard
---------

Today health check
------------------

Health report
--------------

update health check
--------------------

Send health report
------------------

My fields
----------

My trees
---------

Scheduled health checks
-----------------------

Water management
-----------------
with IOT

IOT dash board
---------------

Water a tree:
--------------------
- When user selects this option,a seperate screen will open where user can see a map with all location tags of trees which not watering from last one day.
- User can select the nearest plants from that list.
- By clicking on on tree from the list it will show the route from current loc to selected tree.
- Once user reach there then scan the tag to water,water the tree and submit.
- Data will be stored in the app.Like this any user can Water a  plant.


6.Nearby events:
----------------------
- When user selects this option,a seperate screen will open where user can see a Map with all location tags of  events which   are near to his current location.
- If user is still working in the organisation then he can select each loc tag and he can see all the event details.
- By selecting the loc tag he can see the route to that even.    - If user is not working now then he can see only loc tags.

