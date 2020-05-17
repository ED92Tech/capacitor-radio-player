declare module "@capacitor/core" {
  interface PluginRegistry {
    RadioPlayer: RadioPlayerPlugin;
  }
}

export interface RadioPlayerPlugin {
  // Les types passés en argument & et les types de retur ne sont pas définitifs
  updateMetadata(metadata: {}): Promise<{value: string}>;// Fonction qui recoit le titre et l'album
  tooglePlayPause(): Promise<{value: string}>;// Fonction qui vas inverser le statut actuel
}
