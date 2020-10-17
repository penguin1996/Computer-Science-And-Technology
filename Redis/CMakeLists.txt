cmake_minimum_required(VERSION 3.14)
project(Redis)

set(CMAKE_CXX_STANDARD 14)

add_executable(Redis main.cpp MGraph.cpp MGraph.h ALGraph.cpp)