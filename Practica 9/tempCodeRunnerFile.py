def generate_random_grid(r, c):
    """
    Genera una rejilla aleatoria de dimensiones r x c.
    
    :param r: Número de filas.
    :param c: Número de columnas.
    :return: Lista de listas representando la rejilla.
    """
    grid = [[random.choice([0, 1]) for _ in range(c)] for _ in range(r)]
    grid[0][0] = 0  # Asegurar que el punto de inicio esté libre
    grid[r-1][c-1] = 0  # Asegurar que el punto de destino esté libre
    return grid