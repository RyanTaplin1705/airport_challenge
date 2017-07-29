Introduction
=================

I have created this project to demo TDD for use in my blog ryantapl.in, 
if you wish to refer to some guidelines when working on this challenge please take a look at my blog 
(once complete). If you have any questions or improvemements feelfree to contact me directly on 
github or via the specified contact details on my blog.

This airport challenge was picked up from [Makers Academy GitHub](https://github.com/makersacademy/airport_challenge).
I do not take any credit for the production of this challenge; 
if you have any questions about the requirements I can answer
to the best of my ability but you may need to go to the Makers Academy repository for clarification.

I have changed the project to have use a Maven and Java implementation. 
The original repository has been set up for ruby. 
A blank version of this challenge will be available under the **default_repo** branch. 
You can fork this repo, and clone to your local machine.

Airport Challenge
=================
```
        ______
        _\____\___
=  = ==(____MA____)
          \_____\___________________,-~~~~~~~`-.._
          /     o o o o o o o o o o o o o o o o  |\_
          `~-.__       __..----..__                  )
                `---~~\___________/------------`````
                =  ===(_________)

```

Task
-----

We have a request from a client to write the software to control the flow of planes at an airport. 
The planes can land and take off provided that the weather is sunny. 
Occasionally it may be stormy, in which case no planes can land or take off. 
Here are the user stories that we worked out in collaboration with the client:

```
As an air traffic controller 
So I can get passengers to a destination 
I want to instruct a plane to land at an airport

As an air traffic controller 
So I can get passengers on the way to their destination 
I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport

As an air traffic controller 
To ensure safety 
I want to prevent takeoff when weather is stormy 

As an air traffic controller 
To ensure safety 
I want to prevent landing when weather is stormy 

As an air traffic controller 
To ensure safety 
I want to prevent landing when the airport is full 

As the system designer
So that the software can be used for many different airports
I would like a default airport capacity that can be overridden as appropriate
```
