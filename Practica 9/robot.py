import random

class Robot:
    def __init__(self, grid):
        """
        Inicializa el robot con la rejilla dada.
        
        :param grid: Lista de listas que representa la rejilla. 
                     0 representa una celda libre, 1 representa una celda bloqueada.
        """
        self.grid = grid
        self.rows = len(grid)
        self.cols = len(grid[0]) if self.rows > 0 else 0
        self.path = []

    def find_path(self):
        if self._dfs(0, 0):
            return self.path
        else:
            return None

    def _dfs(self, row, col):
        # Verificar si estamos fuera de los límites o en una celda bloqueada
        if not (0 <= row < self.rows and 0 <= col < self.cols) or self.grid[row][col] == 1:
            return False

        # Verificar si hemos llegado a la esquina inferior derecha
        if row == self.rows - 1 and col == self.cols - 1:
            self.path.append((row, col))
            return True

        # Marcar la celda como parte de la ruta
        self.path.append((row, col))
        self.grid[row][col] = 1  # Marcar como visitado

        # Intentar moverse a la derecha
        if self._dfs(row, col + 1):
            return True

        # Intentar moverse hacia abajo
        if self._dfs(row + 1, col):
            return True

        # Si ninguna dirección es válida, retroceder
        self.path.pop()
        self.grid[row][col] = 0  # Desmarcar la celda
        return False

def generate_random_grid(r, c):
    grid = [[random.choice([0, 1]) for _ in range(c)] for _ in range(r)]
    grid[0][0] = 0  
    grid[r-1][c-1] = 0
    return grid


r = random.randint(5, 10)
c = random.randint(5, 10)
grid = generate_random_grid(r, c)

# Imprimir la rejilla generada
for row in grid:
    print(row)

robot = Robot(grid)
path = robot.find_path()
if path:
    print("Ruta encontrada:", path)
else:
    print("No se encontró ninguna ruta.")
