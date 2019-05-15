
from .shell import *
from .file import File


class Java(object):

    @classmethod
    def compile(cls, file_path):
        shell_command = ['javac', '-classpath', File().get_path_from_file_name(file_name=file_path), file_path]
        return Shell.execute_shell_command(shell_command=shell_command, use_shell=False)

    @classmethod
    def run(cls, run_file_path, get_input_from_command_line=False, input_file_path=None):
        run_file_directory_path = File.get_path_from_file_name(run_file_path)
        run_file_name = File.remove_extension_from_file_name(File.remove_path_from_file_name(run_file_path))
        print("running the java program")
        if input_file_path is None:
            shell_command = ['exec java -classpath ' + run_file_directory_path + ' ' + run_file_name + ' ' + 'States1.txt']
            print('shell_command' + shell_command)
            print('\n')
            run_result = Shell.execute_shell_command(shell_command=shell_command, use_shell=True)
        else:
            if get_input_from_command_line:
                shell_command = 'exec java -classpath ' + run_file_directory_path + '/ ' + run_file_name + ' ' + 'States1.txt' + ' ' + File().get_text_from_file(input_file_path)
                print('shell_command' + shell_command)
                print('\n')
                run_result = Shell.execute_shell_command(shell_command, True)
                print(run_result.output)
            else:
                shell_command = 'exec java -classpath ' + run_file_directory_path + '/ ' + run_file_name + ' ' +run_file_directory_path + '../' + 'States1.txt' + ' < ' + input_file_path + ' > ' + run_file_directory_path + '/out.txt'
                print('input file path' + input_file_path)
                print('\n')
                print('shell_command' + shell_command)
                print('\n')
                run_result = Shell.execute_shell_command(shell_command, True)

                run_result.output = File().get_text_from_file(run_file_directory_path + 'out.txt')
                print(run_result.output)
        return run_result