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
CMAKE_SOURCE_DIR = D:\Project\Computer-Science-And-Technology\DataStructure\String

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = D:\Project\Computer-Science-And-Technology\DataStructure\String\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/String.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/String.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/String.dir/flags.make

CMakeFiles/String.dir/main.c.obj: CMakeFiles/String.dir/flags.make
CMakeFiles/String.dir/main.c.obj: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\Project\Computer-Science-And-Technology\DataStructure\String\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/String.dir/main.c.obj"
	D:\MinGW\mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\String.dir\main.c.obj   -c D:\Project\Computer-Science-And-Technology\DataStructure\String\main.c

CMakeFiles/String.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/String.dir/main.c.i"
	D:\MinGW\mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E D:\Project\Computer-Science-And-Technology\DataStructure\String\main.c > CMakeFiles\String.dir\main.c.i

CMakeFiles/String.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/String.dir/main.c.s"
	D:\MinGW\mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S D:\Project\Computer-Science-And-Technology\DataStructure\String\main.c -o CMakeFiles\String.dir\main.c.s

# Object files for target String
String_OBJECTS = \
"CMakeFiles/String.dir/main.c.obj"

# External object files for target String
String_EXTERNAL_OBJECTS =

String.exe: CMakeFiles/String.dir/main.c.obj
String.exe: CMakeFiles/String.dir/build.make
String.exe: CMakeFiles/String.dir/linklibs.rsp
String.exe: CMakeFiles/String.dir/objects1.rsp
String.exe: CMakeFiles/String.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=D:\Project\Computer-Science-And-Technology\DataStructure\String\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable String.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\String.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/String.dir/build: String.exe

.PHONY : CMakeFiles/String.dir/build

CMakeFiles/String.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\String.dir\cmake_clean.cmake
.PHONY : CMakeFiles/String.dir/clean

CMakeFiles/String.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" D:\Project\Computer-Science-And-Technology\DataStructure\String D:\Project\Computer-Science-And-Technology\DataStructure\String D:\Project\Computer-Science-And-Technology\DataStructure\String\cmake-build-debug D:\Project\Computer-Science-And-Technology\DataStructure\String\cmake-build-debug D:\Project\Computer-Science-And-Technology\DataStructure\String\cmake-build-debug\CMakeFiles\String.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/String.dir/depend

