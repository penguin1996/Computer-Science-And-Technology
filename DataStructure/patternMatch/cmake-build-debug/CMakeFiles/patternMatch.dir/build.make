# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "D:\CLion\CLion 2019.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "D:\CLion\CLion 2019.2\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/patternMatch.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/patternMatch.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/patternMatch.dir/flags.make

CMakeFiles/patternMatch.dir/main.cpp.obj: CMakeFiles/patternMatch.dir/flags.make
CMakeFiles/patternMatch.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/patternMatch.dir/main.cpp.obj"
	D:\MinGW\mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\patternMatch.dir\main.cpp.obj -c D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\main.cpp

CMakeFiles/patternMatch.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/patternMatch.dir/main.cpp.i"
	D:\MinGW\mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\main.cpp > CMakeFiles\patternMatch.dir\main.cpp.i

CMakeFiles/patternMatch.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/patternMatch.dir/main.cpp.s"
	D:\MinGW\mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\main.cpp -o CMakeFiles\patternMatch.dir\main.cpp.s

# Object files for target patternMatch
patternMatch_OBJECTS = \
"CMakeFiles/patternMatch.dir/main.cpp.obj"

# External object files for target patternMatch
patternMatch_EXTERNAL_OBJECTS =

patternMatch.exe: CMakeFiles/patternMatch.dir/main.cpp.obj
patternMatch.exe: CMakeFiles/patternMatch.dir/build.make
patternMatch.exe: CMakeFiles/patternMatch.dir/linklibs.rsp
patternMatch.exe: CMakeFiles/patternMatch.dir/objects1.rsp
patternMatch.exe: CMakeFiles/patternMatch.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable patternMatch.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\patternMatch.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/patternMatch.dir/build: patternMatch.exe

.PHONY : CMakeFiles/patternMatch.dir/build

CMakeFiles/patternMatch.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\patternMatch.dir\cmake_clean.cmake
.PHONY : CMakeFiles/patternMatch.dir/clean

CMakeFiles/patternMatch.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\cmake-build-debug D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\cmake-build-debug D:\Project\Computer-Science-And-Technology\DataStructure\patternMatch\cmake-build-debug\CMakeFiles\patternMatch.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/patternMatch.dir/depend

