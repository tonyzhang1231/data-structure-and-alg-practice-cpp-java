CC=g++
CFLAGS=-c -g -Wall -std=c++14 -Ofast
LDFLAGS=
SOURCES=$(wildcard *.cpp)
#OBJECTS=$(SOURCES:.cpp=.o)
OBJECTS=$(SOURCES:%.cpp=%.o)
EXECUTABLE=twitter


# all: $(SOURCES) $(EXECUTABLE)

all: $(EXECUTABLE)
	
$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

%.o:%.cpp
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -f $(OBJECTS) $(EXECUTABLE)


# https://www.gnu.org/software/make/manual/make.html#Automatic-Variables   for $<  $@
# https://gcc.gnu.org/onlinedocs/gcc-3.0/gcc_3.html     for flags