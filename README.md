# GWT-GXT-Hibernate
Application realizing login / logout logic with GWT and Hibernate

This application is my solution of the test task to some firm. It is my first try in GXT (third in GWT).

Write GWT application. Use maven. First page provides the log in possibility. Page constitutes of head with logo and footer. At interface creation use UiBinder. Customer names and passwords are saved in a data base. After the application start, DB should contain some usernames, passwords, and user localized names. The passwords would be saved with using hash and salt. Interaction with DB should be via Hibernate. After login tha home page should be opened. In this page there should be greeting with user name. Greeting should depend on time. All messages would be localized. Use browser locale. Translate to Russian (Ukrainian) language. If there is no translation, use English. Code should include all possible tests and create readable logging both on clien and server side.

Let me desribe how I developed this application.

I generated GXT project according to the directives given at https://docs.sencha.com/gxt/3.x/getting_started/maven/Archetypes.html. I received maven project with the structure inherent to GWT-project.
I made some settings in "Project.gwt.xml"-file. 
Tags (inherits name="com.google.gwt.activity.Activity"), (inherits name="com.google.gwt.place.Place")
(replace-with class="com.mycompany.gwthibernate.client.ClientFactoryImpl" when-type-is class="com.mycompany.gwthibernate.client.ClientFactory"  replace-with) are essential for Model-View-Presenter (MVP-pattern) functionality which I used to redirect from the registration page to the greening page (for the backward transition I used redirect via href).
Tag (inherits name="com.google.gwt.logging.Logging"), along with (set-property name="gwt.logging......" value="..."),  is used for logging in browser side.

Tag (source path='shared') is used to data interchange between client side and server side (see UserGWT class).

Tag (add-linker name="xsiframe") is used when GWT < 2.7
I removed this tag and changed gwt.version from 2.6.1 to 2.7.? in pom.xml file. But the application ceased to work. I found solution in internet, to create some class in com.google.* with some method. (I am sorry, but I do not remember details.); and application became working.
I also changed source in pom.xml from 1.7 to 1.8 but received errors. I returned to 1.7. However, when I compiled with JDK 1.8, I did not received errors in GreetingFactory1, where java.time.LocalTime is  used. But I kept GreetingFactory (JDK 1.7 compatible).

