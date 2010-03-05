# Wind River Workbench generated Makefile.
# Do not edit!!!
#
# The file ".wrmakefile" is the template used by the Wind River Workbench to
# generate the makefiles of this project. Add user-specific build targets and
# make rules only(!) in this project's ".wrmakefile" file. These will then be
# automatically dumped into the makefiles.

WIND_HOME := $(subst \,/,$(WIND_HOME))
WIND_BASE := $(subst \,/,$(WIND_BASE))
WIND_USR := $(subst \,/,$(WIND_USR))

all : pre_build main_all post_build

_clean ::
	@echo "make: removing targets and objects of `pwd`"

TRACE=0
TRACEON=$(TRACE:0=@)
TRACE_FLAG=$(TRACEON:1=)

MAKEFILE := Makefile

FLEXIBLE_BUILD := 1

BUILD_SPEC = PPC32diab
DEBUG_MODE = 1
ifeq ($(DEBUG_MODE),1)
MODE_DIR := Debug
else
MODE_DIR := NonDebug
endif
OBJ_DIR := .
PRJ_ROOT_DIR := E:/workspace/AmoreRobot
WS_ROOT_DIR := E:/workspace



#Global Build Macros
PROJECT_TYPE = DKM
DEFINES = 
EXPAND_DBG = 0


#BuildSpec specific Build Macros
VX_CPU_FAMILY = ppc
CPU = PPC32
TOOL_FAMILY = diab
TOOL = diab
TOOL_PATH = 
CC_ARCH_SPEC = -tPPCFH:vxworks63 -Xstmw-slow -DPPC32_fp60x
LIBPATH = 
LIBS = 

IDE_INCLUDES = -I$(WIND_BASE)/target/h -I$(WIND_BASE)/target/h/wrn/coreip -IE:/workspace/Simplemodified/AmoreRobot -I$(WIND_BASE)/target/h/WPIlib 

IDE_LIBRARIES = 



#BuildTool flags
ifeq ($(DEBUG_MODE),1)
DEBUGFLAGS_C-Compiler = -g
DEBUGFLAGS_C++-Compiler = -g
DEBUGFLAGS_Linker = -g
DEBUGFLAGS_Partial-Image-Linker = 
DEBUGFLAGS_Librarian = 
DEBUGFLAGS_Assembler = -g
else
DEBUGFLAGS_C-Compiler = -XO -Xsize-opt
DEBUGFLAGS_C++-Compiler = -XO -Xsize-opt
DEBUGFLAGS_Linker = -XO -Xsize-opt
DEBUGFLAGS_Partial-Image-Linker = 
DEBUGFLAGS_Librarian = 
DEBUGFLAGS_Assembler = -XO -Xsize-opt
endif


#Project Targets
PROJECT_TARGETS = AmoreRobot/$(MODE_DIR)/AmoreRobot.out \
	 AmoreRobot_partialImage/$(MODE_DIR)/AmoreRobot_partialImage.o


#Rules

# AmoreRobot
ifeq ($(DEBUG_MODE),1)
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_C-Compiler = -g
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_C++-Compiler = -g
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_Linker = -g
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_Partial-Image-Linker = 
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_Librarian = 
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_Assembler = -g
else
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_C-Compiler = -XO -Xsize-opt
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_C++-Compiler = -XO -Xsize-opt
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_Linker = -XO -Xsize-opt
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_Partial-Image-Linker = 
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_Librarian = 
AmoreRobot/$(MODE_DIR)/% : DEBUGFLAGS_Assembler = -XO -Xsize-opt
endif
AmoreRobot/$(MODE_DIR)/% : IDE_INCLUDES = -I$(WIND_BASE)/target/h -I$(WIND_BASE)/target/h/wrn/coreip -IE:/workspace/Simplemodified/AmoreRobot -I$(WIND_BASE)/target/h/WPIlib 
AmoreRobot/$(MODE_DIR)/% : IDE_LIBRARIES = 
AmoreRobot/$(MODE_DIR)/% : PROJECT_TYPE = DKM
AmoreRobot/$(MODE_DIR)/% : DEFINES = 
AmoreRobot/$(MODE_DIR)/% : EXPAND_DBG = 0
AmoreRobot/$(MODE_DIR)/% : VX_CPU_FAMILY = ppc
AmoreRobot/$(MODE_DIR)/% : CPU = PPC32
AmoreRobot/$(MODE_DIR)/% : TOOL_FAMILY = diab
AmoreRobot/$(MODE_DIR)/% : TOOL = diab
AmoreRobot/$(MODE_DIR)/% : TOOL_PATH = 
AmoreRobot/$(MODE_DIR)/% : CC_ARCH_SPEC = -tPPCFH:vxworks63 -Xstmw-slow -DPPC32_fp60x
AmoreRobot/$(MODE_DIR)/% : LIBPATH = 
AmoreRobot/$(MODE_DIR)/% : LIBS = 
AmoreRobot/$(MODE_DIR)/% : OBJ_DIR := AmoreRobot/$(MODE_DIR)

OBJECTS_AmoreRobot = AmoreRobot_partialImage/$(MODE_DIR)/AmoreRobot_partialImage.o

AmoreRobot/$(MODE_DIR)/AmoreRobot.out : $(OBJECTS_AmoreRobot)
	$(TRACE_FLAG)if [ ! -d "`dirname "$@"`" ]; then mkdir -p "`dirname "$@"`"; fi;echo "building $@";rm -f "$@";ddump -Ng $(OBJECTS_AmoreRobot) $(IDE_LIBRARIES) | tclsh $(WIND_BASE)/host/resource/hutils/tcl/munch.tcl -c ppc > $(OBJ_DIR)/ctdt.c; $(TOOL_PATH)dcc $(DEBUGFLAGS_Linker) $(CC_ARCH_SPEC) -Xdollar-in-ident -Xforce-declarations $(ADDED_CFLAGS) $(IDE_INCLUDES) $(ADDED_INCLUDES) -DCPU=$(CPU) -DTOOL_FAMILY=$(TOOL_FAMILY) -DTOOL=$(TOOL) -D_WRS_KERNEL   $(DEFINES)  -o $(OBJ_DIR)/ctdt.o -c $(OBJ_DIR)/ctdt.c; $(TOOL_PATH)dld -tPPCFH:vxworks63 -X -r5 -r4 -o "$@" $(OBJ_DIR)/ctdt.o $(OBJECTS_AmoreRobot) $(IDE_LIBRARIES) $(LIBPATH) $(LIBS)  $(ADDED_LIBPATH) $(ADDED_LIBS) && if [ "$(EXPAND_DBG)" = "1" ]; then plink "$@";fi

AmoreRobot/$(MODE_DIR)/AmoreRobot_compile_file : $(FILE) ;

_clean :: AmoreRobot/$(MODE_DIR)/AmoreRobot_clean

AmoreRobot/$(MODE_DIR)/AmoreRobot_clean : 
	$(TRACE_FLAG)if [ -d "AmoreRobot" ]; then cd "AmoreRobot"; rm -rf $(MODE_DIR); fi


# AmoreRobot_partialImage
ifeq ($(DEBUG_MODE),1)
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_C-Compiler = -g
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_C++-Compiler = -g
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_Linker = -g
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_Partial-Image-Linker = 
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_Librarian = 
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_Assembler = -g
else
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_C-Compiler = -XO -Xsize-opt
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_C++-Compiler = -XO -Xsize-opt
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_Linker = -XO -Xsize-opt
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_Partial-Image-Linker = 
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_Librarian = 
AmoreRobot_partialImage/$(MODE_DIR)/% : DEBUGFLAGS_Assembler = -XO -Xsize-opt
endif
AmoreRobot_partialImage/$(MODE_DIR)/% : IDE_INCLUDES = -I$(WIND_BASE)/target/h -I$(WIND_BASE)/target/h/wrn/coreip -IE:/workspace/Simplemodified/AmoreRobot -I$(WIND_BASE)/target/h/WPIlib 
AmoreRobot_partialImage/$(MODE_DIR)/% : IDE_LIBRARIES = 
AmoreRobot_partialImage/$(MODE_DIR)/% : PROJECT_TYPE = DKM
AmoreRobot_partialImage/$(MODE_DIR)/% : DEFINES = 
AmoreRobot_partialImage/$(MODE_DIR)/% : EXPAND_DBG = 0
AmoreRobot_partialImage/$(MODE_DIR)/% : VX_CPU_FAMILY = ppc
AmoreRobot_partialImage/$(MODE_DIR)/% : CPU = PPC32
AmoreRobot_partialImage/$(MODE_DIR)/% : TOOL_FAMILY = diab
AmoreRobot_partialImage/$(MODE_DIR)/% : TOOL = diab
AmoreRobot_partialImage/$(MODE_DIR)/% : TOOL_PATH = 
AmoreRobot_partialImage/$(MODE_DIR)/% : CC_ARCH_SPEC = -tPPCFH:vxworks63 -Xstmw-slow -DPPC32_fp60x
AmoreRobot_partialImage/$(MODE_DIR)/% : LIBPATH = 
AmoreRobot_partialImage/$(MODE_DIR)/% : LIBS = 
AmoreRobot_partialImage/$(MODE_DIR)/% : OBJ_DIR := AmoreRobot_partialImage/$(MODE_DIR)

AmoreRobot_partialImage/$(MODE_DIR)/Objects/AmoreRobot/Robot.o : E:/workspace/AmoreRobot/Robot.cpp
	$(TRACE_FLAG)if [ ! -d "`dirname "$@"`" ]; then mkdir -p "`dirname "$@"`"; fi;echo "building $@"; $(TOOL_PATH)dcc $(DEBUGFLAGS_C++-Compiler) $(CC_ARCH_SPEC) -W:c:,-Xclib-optim-off -Xansi -Xlocal-data-area-static-only -Xforce-declarations  -Xmake-dependency=0xd $(ADDED_C++FLAGS) $(IDE_INCLUDES) $(ADDED_INCLUDES) -DCPU=$(CPU) -DTOOL_FAMILY=$(TOOL_FAMILY) -DTOOL=$(TOOL) -D_WRS_KERNEL   $(DEFINES) -o "$@" -c "$<"


OBJECTS_AmoreRobot_partialImage = AmoreRobot_partialImage/$(MODE_DIR)/Objects/AmoreRobot/Robot.o

AmoreRobot_partialImage/$(MODE_DIR)/AmoreRobot_partialImage.o : $(OBJECTS_AmoreRobot_partialImage)
	$(TRACE_FLAG)if [ ! -d "`dirname "$@"`" ]; then mkdir -p "`dirname "$@"`"; fi;echo "building $@"; $(TOOL_PATH)dld -tPPCFH:vxworks63 -X -r5  -o "$@" $(OBJECTS_AmoreRobot_partialImage) $(LIBPATH) $(LIBS) $(ADDED_LIBPATH) $(ADDED_LIBS)  && if [ "$(EXPAND_DBG)" = "1" ]; then plink "$@";fi

AmoreRobot_partialImage/$(MODE_DIR)/AmoreRobot_partialImage_compile_file : $(FILE) ;

_clean :: AmoreRobot_partialImage/$(MODE_DIR)/AmoreRobot_partialImage_clean

AmoreRobot_partialImage/$(MODE_DIR)/AmoreRobot_partialImage_clean : 
	$(TRACE_FLAG)if [ -d "AmoreRobot_partialImage" ]; then cd "AmoreRobot_partialImage"; rm -rf $(MODE_DIR); fi

DEP_FILES := AmoreRobot_partialImage/$(MODE_DIR)/Objects/AmoreRobot/Robot.d
-include $(DEP_FILES)



-include $(PRJ_ROOT_DIR)/*.makefile

-include *.makefile

main_all : external_build $(PROJECT_TARGETS)
	@echo "make: built targets of `pwd`"

# entry point for extending the build
external_build ::
	@echo ""

# main entry point for pre processing prior to the build
pre_build :: $(PRE_BUILD_STEP) generate_sources
	@echo ""

# entry point for generating sources prior to the build
generate_sources ::
	@echo ""

# main entry point for post processing after the build
post_build :: $(POST_BUILD_STEP) deploy_output
	@echo ""

# entry point for deploying output after the build
deploy_output ::
	@echo ""

clean :: external_clean $(CLEAN_STEP) _clean

# entry point for extending the build clean
external_clean ::
	@echo ""
