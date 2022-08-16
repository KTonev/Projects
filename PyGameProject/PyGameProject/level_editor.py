import pygame
import pickle

pygame.init()

clock = pygame.time.Clock()
fps = 60

# game window
tile_size = 50
cols = 20
margin = 100
screen_width = tile_size * cols
screen_height = (tile_size * cols) + margin

screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption('Level Editor')

# load images
bg_img = pygame.image.load('img/background.png')
bg_img = pygame.transform.scale(bg_img, (screen_width, screen_height - margin))
ice_img = pygame.image.load('img/ice.png')
snow_img = pygame.image.load('img/snow.png')
minion_img = pygame.image.load('img/minion.png')
platform_x_img = pygame.image.load('img/platform.png')
platform_y_img = pygame.image.load('img/platform.png')
lava_img = pygame.image.load('img/lava.png')
shield_img = pygame.image.load('img/shield.png')
portal_img = pygame.image.load('img/portal.png')
save_img = pygame.image.load('img/save_btn.png')

# game variables
clicked = False
level = 0

# colours
white = (255, 255, 255)
blue = (150, 200, 255)

font = pygame.font.SysFont('Futura', 24)

# empty tile list
world_data = []
for row in range(20):
    r = [0] * 20
    world_data.append(r)

# boundary
for tile in range(0, 20):
    world_data[19][tile] = 2
    world_data[0][tile] = 1
    world_data[tile][0] = 1
    world_data[tile][19] = 1


# outputting text onto the screen
def draw_text(text, font, text_col, x, y):
    img = font.render(text, True, text_col)
    screen.blit(img, (x, y))


def draw_grid():
    for c in range(21):
        # vertical lines
        pygame.draw.line(screen, white, (c * tile_size, 0), (c * tile_size, screen_height - margin))
        # horizontal lines
        pygame.draw.line(screen, white, (0, c * tile_size), (screen_width, c * tile_size))


def draw_world():
    for row in range(20):
        for col in range(20):
            if world_data[row][col] > 0:
                if world_data[row][col] == 1:
                    # ice blocks
                    img = pygame.transform.scale(ice_img, (tile_size, tile_size))
                    screen.blit(img, (col * tile_size, row * tile_size))
                if world_data[row][col] == 2:
                    # snow blocks
                    img = pygame.transform.scale(snow_img, (tile_size, tile_size))
                    screen.blit(img, (col * tile_size, row * tile_size))
                if world_data[row][col] == 3:
                    # enemy blocks
                    img = pygame.transform.scale(minion_img, (tile_size, int(tile_size * 0.75)))
                    screen.blit(img, (col * tile_size, row * tile_size + (tile_size * 0.25)))
                if world_data[row][col] == 4:
                    # horizontally moving platform
                    img = pygame.transform.scale(platform_x_img, (tile_size, tile_size // 2))
                    screen.blit(img, (col * tile_size, row * tile_size))
                if world_data[row][col] == 5:
                    # vertically moving platform
                    img = pygame.transform.scale(platform_y_img, (tile_size, tile_size // 2))
                    screen.blit(img, (col * tile_size, row * tile_size))
                if world_data[row][col] == 6:
                    # lava
                    img = pygame.transform.scale(lava_img, (tile_size, tile_size // 2))
                    screen.blit(img, (col * tile_size, row * tile_size + (tile_size // 2)))
                if world_data[row][col] == 7:
                    # shield
                    img = pygame.transform.scale(shield_img, (tile_size // 2, tile_size // 2))
                    screen.blit(img, (col * tile_size + (tile_size // 4), row * tile_size + (tile_size // 4)))
                if world_data[row][col] == 8:
                    # portal
                    img = pygame.transform.scale(portal_img, (tile_size, int(tile_size * 1.5)))
                    screen.blit(img, (col * tile_size, row * tile_size - (tile_size // 2)))


class Button():
    def __init__(self, x, y, image):
        self.image = image
        self.rect = self.image.get_rect()
        self.rect.topleft = (x, y)
        self.clicked = False

    def draw(self):
        action = False

        # mouse position
        pos = pygame.mouse.get_pos()

        # mouseover and clicked conditions
        if self.rect.collidepoint(pos):
            if pygame.mouse.get_pressed()[0] == 1 and self.clicked == False:
                action = True
                self.clicked = True

        if pygame.mouse.get_pressed()[0] == 0:
            self.clicked = False

        # draw button
        screen.blit(self.image, (self.rect.x, self.rect.y))

        return action


# save button
save_button = Button(screen_width // 2, screen_height - 80, save_img)


run = True
while run:

    clock.tick(fps)

    # draw background
    screen.fill(blue)
    screen.blit(bg_img, (0, 0))

    # save level
    if save_button.draw():
        # save level data
        pickle_out = open(f'level{level}_data', 'wb')
        pickle.dump(world_data, pickle_out)
        pickle_out.close()

    draw_grid()
    draw_world()

    # text showing current level
    draw_text(f'Level: {level}', font, white, tile_size, screen_height - 60)
    draw_text('Press UP or DOWN to change level', font, white, tile_size, screen_height - 40)

    # event handler
    for event in pygame.event.get():
        # quit game
        if event.type == pygame.QUIT:
            run = False
        # mouseclicks to change tiles
        if event.type == pygame.MOUSEBUTTONDOWN and clicked == False:
            clicked = True
            pos = pygame.mouse.get_pos()
            x = pos[0] // tile_size
            y = pos[1] // tile_size

            # check coordinates are within the tile area
            if x < 20 and y < 20:
                # update tile
                if pygame.mouse.get_pressed()[0] == 1:
                    world_data[y][x] += 1
                    if world_data[y][x] > 8:
                        world_data[y][x] = 0
                elif pygame.mouse.get_pressed()[2] == 1:
                    world_data[y][x] -= 1
                    if world_data[y][x] < 0:
                        world_data[y][x] = 8
        if event.type == pygame.MOUSEBUTTONUP:
            clicked = False
        # up and down key presses to change level number
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_UP:
                level += 1
            elif event.key == pygame.K_DOWN and level > 1:
                level -= 1

    # update game display window
    pygame.display.update()

pygame.quit()
