# Exercise5

The aim of this exercise is to create a drawing application that allows :
  - **Drawing rectangles, ellipse and lines**
  - **Select and Move shapes**
  - **Duplicating and Deleting shapes**
  - **Selecting the color of shapes**

<p align="center"><img src="/img/Exercise5.PNG"></p>

1) Import this project in Eclipse

> *To import this project in eclipse, you should open Eclipse and follow these steps:*
>  1) *Go to File \> Import...*
>  2) *Select Git \> Projects from Git*
>  3) *Select Clone URI*
>  4) *Fill the URI box with `https://github.com/IntroductionProgIS/Exercise5.git` (All the other parts should be automatically filled)*
>  5) *Click on "Next", "Next" and "Finish"*

> *To see the tasks that you need to do in a project: Go to Eclipse and select Window \> Show View \> Tasks*i

2) Modify the DrawingController\_Implemented class to enable mode selection: when the user clicks on a radio button, it should change the mode and update the window title accordingly

3) Modify the code to enable shape selection: when the "Select/Move" mode is active, when the user clicks on the canvas, the shape directly under the cursor should be selected. You will also have to implement the selectedShape method that handles the picking of a shape at a location p on the 2D canvas, in the ClickEventHandler.

4) Set the appropriate actions for the Delete and Clone buttons so that the user can delete or clone (and translate a bit) the selected shape.

5) Modify the code to let users move shapes in the canvas.

6) Enable the color setters that set the fill and stroke color of the currently selected shape and also future shapes. Also, make sure that when the user selects a shape, the color setters should be updated to reflect the fill and stroke colors of this shape.

7) Add the support of other shapes by implementing the addEllipse and addLine functions in DrawingController\_Implemented and DrawingModel\_Implemented classes. They should support the same features: move, delete, color change, etc.
