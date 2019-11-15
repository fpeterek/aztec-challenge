# Aztec Challenge

Aztec Challenge, rewritten in Java for a school project. I do not like Java, I do not like programming in Java, nor do 
I agree with the probihition of static methods, unfortunately, such were the requirements.

Aztec Challenge is a a classical game that I, in no way, wish to mock or disrespect. This version is probably far from
perfect and far from the original, but as I said, it's a school project with requirements I highly disagree with, I'm not
proud of it, I was forced to create it this way.

## Licensing

All code in this repository was written by me and is licensed under the Apache license. 
All pixelart was made by me. Fonts were not.
`lcd-solid` font was downloaded off the internet and `Herculanum` was already present on my computer.

## Compilation

This project uses Gradle as it's build system. You should, as is the convention in Gradle, utilize the Gradle wrapper.

To compile, type `./gradlew build`. To run the project, type `./gradlew run`. To create an executable .jar archive, type
`./gradlew jar`. I prefer to run the project using Gradle as opposed to creating a .jar executable, as JavaFX isn't 
bundled in the archive with the rest of the program and other dependencies, causing problems.

## KeyLogger

There's a keylogger present in this project. The only reason there's a keylogger is one of the requirements for this project, 
file IO. The keylogger only logs input the app receives, not other keys. The input is stored in a directory specified in config
file. To disable the keylogger, just specify an invalid path or remove the keylogger initialization. 
