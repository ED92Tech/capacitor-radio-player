declare module "@capacitor/core" {
  interface PluginRegistry {
    RadioPlayer: RadioPlayerPlugin;
  }
}

export interface RadioPlayerPlugin {
  echo(options: { value: string }): Promise<{value: string}>;
}
