For next week, you'll want to have a clear idea of what your project is going to be. Then, in the next lab, I will help you scope your project appropriately. In this repo, write the following:
1.	A one-liner (exactly 1 sentence) that describes your project.
Our group is planning to create a tower defense simulator consisting of enemy entities following a predestined path where they will systematically encounter the player’s “towers” trying to impede their movement. 
2.	A list of points (about 5-10 sentences) that describes how your project meets each of the requirement criteria.
-	We will use the processing.org libraries to create visual interfaces. Our game will have a visual interface to represent a map, characters, and enemies.
-	We are going to write test cases to ensure the game is working as we intended it to
-	We will save our game state in a database. (wave, points after every wave)
-	Our group will be documenting all the meetings, so we are aware of progress and keep ourselves within the scope. This will be done by having good commit messages, writing process reports…
3.	Answers to the below group discussion items (meetings, communication, roles, and expectations).
A large portion of your mark for this course will be work that you do within the context of a group. My expectations are that all group members contribute fully to the best of their abilities. Since everyone will have different abilities, preferences, and interests, this can sometimes be difficult to negotiate.
1.	Every group member must be on a common chat application, and must check and respond to messages within a day during normal business hours.
2.	Every group member must volunteer to take on project tasks and complete them by the associated deadlines. These tasks MUST be managed using GitHub issues. Each group member is responsible for creating and closing GitHub issues for tasks they have taken on.
3.	The group must meet at least once during the week outside of class time to discuss the status of project tasks. All group members must be present during this meeting.
4.	For official/important decision-making meetings, an ongoing minutes document must be maintained where attendance and group decisions are recorded.
5.	Groups must decide on a way of formally negotiating disputes. Default will be consensus with 2/3rds majority vote unless another system is explicitly decided upon.
If there are disputes that require mediation from me, I will be happy to help the group find a solution that is amenable to all. In your first group meeting, you will want to discuss the following:
1.	Meeting time and format: when will you meet and how?
a.	Monday after class, and Wednesdays if needed. Both in person.
2.	Communications expectations and format: what times of day are people available and by which medium?
a.	Efficient communication via Discord with an expectation of one business day to reply.
3.	Roles and responsibilities: who will do what part of the group aspects of the project, including project management?
a.	Facilitator • Moderates team discussions • Keeps the group on task • Ensures equal involvement • Ensures equal opportunities to learn, participate and earn respect 
-	Cheryl 
b.	Recorder • Distributes and hands in materials • Completes worksheets, written assignments or summaries for oral reports 
-	Aric 
c.	Reporter • Summarizes the group’s activities or conclusions • Assists the recorder with writing worksheets and group reports 
-	Victor 
d.	Timekeeper • Keeps the group aware of time constraints • Aids the facilitator in keeping the team on task • Consults with other teams if needed • Leaves the work area in good condition • Fills in for an absent member if there is no fifth member 
-	Gursidh
e.	Wild card • Fills in for an absent member
-	Quan
4.	Abilities and expectations: how much effort do people want to put into the project and in what areas do they have expertise?
a.	Our group is aiming for an A grade
Timeline: 
Week 1 
-	Finish UML diagrams and initiate GitHub issues 
Week 2 
-	Write major classes and define some preliminary methods 
Week 3 
-	Begin testing functionalities 
Week 4 
-	Flesh out classes 
Week 5 
-	Complete the asynchronous processing function 
-	Define non-trivial processing data state 
Week 6
-     Final testing and polish 


Aric's Individual Pitch 
Create the abstract class Sprite, Bullet and BulletManager classes, in addition to the Movable, Collidable, and Drawable interfaces that my classes will use. Will also create the User Interface for the game. 
Link to my individual UML: https://lucid.app/lucidchart/6374c9c3-ae59-4825-8218-2a28836e6774/edit?viewport_loc=-618%2C-560%2C2976%2C1618%2C0_0&invitationId=inv_78f664df-33f0-49ea-b901-db3ade92b6a6

Cheryl's Individual Pitch
Develop the Window class in which the game is played on and render the image depending on the game state (PLAYING, PAUSED, MENU).
Save Player information to a database to retrieve when the same Player is selected.
Write game data to the database (current level, number of towers, current score, creeps killed)
Retrieve data from database to load game progress.
Link to my diagram: https://lucid.app/lucidchart/3c9cd7cd-8612-4432-92c6-f70b56f7127a/edit?viewport_loc=-898%2C-682%2C2466%2C1172%2C0_0&invitationId=inv_9125c3b1-e3f1-408a-96c3-a11f92cc0aa2


Gursidh's Individual Pitch
Create a Tower class that implements a Tower Manager superclass. The Tower Manager will handle all the Tower objects. In addition, Tower will also implement the abstract class Sprite which also implements Collidable. Will also be creating the UI Manager class alongside Victor which is connected to Window. 
Link to my individual UML: https://lucid.app/lucidchart/66d6bb77-2ee2-492b-8749-46daf81ce463/edit?invitationId=inv_56290ed1-47ee-4efd-a527-bb2c8e1baaca&page=0_0#

Victor's Individual Pitch
Create a Enemy class that implements a Enemy Manager superclass. The Enemy Manager will manage all the Enemy objects and store them in an array. Also, Enemy will implement abstract class Sprite, as well as the interfaces Collidable and Movable. Finally, create an UI Manager class alongside Gursidh. 
Link to my individual UML: https://lucid.app/lucidchart/dceae253-d48a-4638-9fd2-3562ea5fa071/edit?beaconFlowId=D28BF4163CD052FB&invitationId=inv_97bfffd1-b9fa-49f5-b9ee-047342d68bb4&page=0_0#

In Class Check:
Cheryl's parts are approved and we should be able to keep re-writing data to the database as the player keeps playing the game. Gursidh and Victor should split the collidable interface, as well as working on their own classes, because Enemy and Tower will be the classes that implement this interface the most. Aric should continue his tasks but should be in charge of UI manager instead of Gursidh and Victor splitting it. Quan's tasks are approved as well.
