# Model-View-ViewModel (i.e. MVVM)

This repository contains the code for the MVVM.

**What is MVVM?**

MVVM is a flexible guide and set of libraries used to standardize an app's architecture. What this means is that your code is split into distinct components that hold specific parts of code in specific areas. These parts then interact with each other in a set order. These parts are:

![Logo](https://uploads.toptal.io/blog/image/127608/toptal-blog-image-1543413671794-80993a19fea97477524763c908b50a7a.png)

**Model**

The Model consists of three parts,

        # Database Class
        # DAO Interfaces
        # Data Model Classes

**View**

The View is the UI presentation logic. It consists of,

        # Activities
        # Fragments
        # Adapters
        # XML
        
        The View should only be responsible for displaying values and state. Another way to say that is you should not make database requests and/or network requests in the View. These will be done elsewhere. This means the Views don't care where the data comes from or how it gets there, it just shows whatever data there is. This way, if a change needs to be made to the database, the View should not need to be changed at all.

**View Model**

The View Model is responsible for interacting with the Database and coordinating between any remote sources.
It is then responsible for representing the state of the data to the View.

        # ViewModels provided by the Jetpack components are also Lifecycle aware, and can survive configuration changes. This helps:
        # Prevent memory leaks
        # Prevent errant network calls
        # Prevent null pointer exceptions due to UI changes
        # Solves the issue of what happens when you rotate an app

**How it works**

As mentioned before MVVM breaks the app into components and they interact in a certain way. This interaction follows the pattern:

        # The View subscribes to a LiveData from a ViewModel
        # The ViewModel connects to a repository
        # The Repository connects to databases, both remote and local, if there are both
        # The Repository returns the requested data to the the ViewModel
        # The ViewModel formats the data and exposes it through a LiveData
        # The View's subscriptions are notified of any changes through the LIveData, and updates the UI to match

# Java Version

The Java version of this codelab is available under the build.app branch of this repository.

# Pre-requisites

Make sure Android Studio is updated, as well as your SDK and Gradle. Otherwise, you may have to wait for a while until all the updates are done.

A device or emulator that runs API level 31.


# How to use it

        Add dependency in build.app folder.

        def lifecycle_version = "2.2.0"
        // lifecycle

        implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
        annotationProcessor "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"

**Summary**

        # The usage of all patterns is situational, and the benefit (if there is any) always lies in reduced complexity.
        # MVVM guides us how to distribute responsibilities between classes in a GUI application.
        # ViewModel projects the data from the Model into a format that fits the View.
        # For trivial projects MVVM is unnecessary. Using only the View is sufficient.
        # For simple projects, the ViewModel/Model split may be unnecessary, and just using a Model and a View is good enough.
        # Model and ViewModel do not need to exist from the start and can be introduced when they are needed.


**Opening a sample in Android Studio**

To open one of the samples in Android Studio, begin by checking out one of the sample branches, and then open the root directory in Android Studio.

Clone the repository:

**git clone**

        1. https://github.com/emorphisgit/MVVM-Code-Repository
        2. git checkout master
